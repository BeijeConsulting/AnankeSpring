package it.beije.ananke.ecommerce.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.ecommerce.Order;
import it.beije.ananke.ecommerce.OrderItem;
import it.beije.ananke.ecommerce.Product;
import it.beije.ananke.ecommerce.User;
import it.beije.ananke.ecommerce.service.OrderService;
import it.beije.ananke.ecommerce.service.ProductService;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProductsDetailsRestController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/product-details")
	public Product details(@RequestParam int id) {
		Product product = productService.findById(id);
		return product;
	}
	
	@PutMapping(value = "/product-details")
	public Order details(int userId, Order orderBean, int id, int qnt) {	
		Product product = productService.findById(id);
		double amount = qnt * product.getPrice();
		boolean update = false;
		
		//creo un nuovo ordine o prendo l'ordine in corso

		List<Order> orderList = orderService.findByUserId(userId);

		for(Order ord : orderList) {
			if(ord.getState().equals("in progress")) {
				orderBean = ord;
				break;
			}
		}
	
		String orderState = orderBean.getState();
		if(orderState == null) {
			orderBean.setState("in progress");
			orderBean.setUserId(userId);
			orderBean = orderService.save(orderBean);
		}
	
		double orderAmount = orderBean.getAmount();
		double total = orderAmount += amount;
		orderBean.setAmount(total);	
		orderBean = orderService.save(orderBean);
		
		//non faccio alcuna operazione se la quantità è pari a zero
		
		if(qnt > 0) {
			//aggiorno un item già esistente se il prodotto è lo stesso
			List<OrderItem> orderItems = orderService.findByOrder(orderBean.getId());
			for(OrderItem item : orderItems) {
				if(item.getProductId() == id) {
					double itemAmount = item.getAmount();
					int quantityItem = item.getQuantity();
					item.setQuantity(quantityItem += qnt);
					item.setAmount(itemAmount += amount);
					orderService.save(item);
					update = true;
				}
			}
			
			//creo un nuovo order item se il prodotto è nuovo
			if(!update) {	
				System.out.println("update = false");
				OrderItem orderItem = new OrderItem();
				orderItem.setQuantity(qnt);
				orderItem.setProductId(id);
				orderItem.setOrderId(orderBean.getId());
				orderItem.setAmount(qnt * product.getPrice());
				orderService.save(orderItem);
			}		
		}
		return orderBean;
	}
}
