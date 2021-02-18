package it.beije.ananke.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.ecommerce.Order;
import it.beije.ananke.ecommerce.OrderItem;
import it.beije.ananke.ecommerce.Product;
import it.beije.ananke.ecommerce.User;
import it.beije.ananke.ecommerce.service.OrderService;
import it.beije.ananke.ecommerce.service.ProductService;

@Controller
public class ProductsDetailsController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/product-details", method = RequestMethod.GET)
	public String details(@RequestParam int id, Model model) {
//		JPAmanager jpa = new JPAmanager();
//		Product product = new Product();
//		product = jpa.findProduct(id);
//		model.addAttribute("product", product);
//		return "product-details";
		Product product = productService.findById(id);
		model.addAttribute("product", product);
		return "product-details";
	}
	
	@RequestMapping(value = "/product-details", method = RequestMethod.POST)
	public String details(@RequestParam int id, @RequestParam int qnt, Model model, HttpSession session) {	
		Product product = productService.findById(id);
		User userBean = (User) session.getAttribute("userBean");
		Integer userId = userBean.getId();
		double amount = qnt * product.getPrice();
		boolean update = false;
		
		//creo un nuovo ordine o prendo l'ordine in corso

		Order orderBean = (Order) session.getAttribute("orderBean");
		Order order = new Order();
		List<Order> orderList = orderService.findByUserId(userId);
		for(Order ord : orderList) {
			if(ord.getState().equals("in progress")) {
				order = ord;
				break;
			}
		}
	
		String orderState = orderBean.getState();
		if(orderState == null || order == null) {
			orderBean.setState("in progress");
			orderBean.setUserId(userId);
			order = orderService.save(orderBean);
		}
	
		double orderAmount = order.getAmount();
		double total = orderAmount += amount;
		order.setAmount(total);	
		orderService.save(order);
		
		//non faccio alcuna operazione se la quantità è pari a zero
		
		if(qnt > 0) {
			//aggiorno un item già esistente se il prodotto è lo stesso
			List<OrderItem> orderItems = orderService.findByOrder(order.getId());
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
				orderItem.setOrderId(order.getId());
				orderItem.setAmount(qnt * product.getPrice());
				orderService.save(orderItem);
			}		
		}
//		orderItems = orderService.findByOrder(order.getId());
//		model.addAttribute("orderItems", orderItems);
//		model.addAttribute("totale", totale);
		
//		HashSet<Product> products = new HashSet<Product>();
//		for(OrderItem ord : orderItems) {
//			products.add(productService.findById(ord.getProductId()));
//		}

		//model.addAttribute("qnt", qnt);
		//model.addAttribute("orderItem", orderItem);
					
		return "redirect:/order?id=" + order.getId();
	}
}
