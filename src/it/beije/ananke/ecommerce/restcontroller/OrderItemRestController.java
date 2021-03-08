package it.beije.ananke.ecommerce.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.ecommerce.model.Order;
import it.beije.ananke.ecommerce.model.OrderItem;
import it.beije.ananke.ecommerce.model.Product;
import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.service.OrderItemService;
import it.beije.ananke.ecommerce.service.OrderService;
import it.beije.ananke.ecommerce.service.ProductService;
import it.beije.ananke.ecommerce.util.OrderState;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class OrderItemRestController {

	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addToCart")
	public OrderItem addToCart(@RequestBody OrderItem requestedOrderItem, HttpSession session) {
		System.out.println("sto chiamando addToCart");
		System.out.println("request user:" + requestedOrderItem.getProductId());
		User user = (User) session.getAttribute("user");
		Product product = productService.findById(requestedOrderItem.getProductId());
		if (user != null) {
			System.out.println("request user:" + requestedOrderItem.getProductId());
			Order order = orderService.findByUserIdAndState(user.getId(),"OPEN");
			if(order!=null) {
				System.out.println("order exists? " + order!=null);
				OrderItem orderItem = orderItemService.addToCart(order.getId(), requestedOrderItem.getProductId(), requestedOrderItem.getQuantity(), product.getPrice());
				System.out.println("order item? " + orderItem);
				orderItemService.save(orderItem);
				orderService.updatePrice(order, orderItem);
				orderService.save(order);
				return orderItem;
			} else {
				order = new Order();
				order.setState("OPEN");
				order.setUserId(user.getId());
				order.setAmount(new Double(0));
				orderService.save(order);
				System.out.println("order created? " + order!=null);
				OrderItem orderItem = orderItemService.addToCart(order.getId(), requestedOrderItem.getProductId(), requestedOrderItem.getQuantity(), product.getPrice());
				orderItemService.save(orderItem);
				System.out.println("order item? " + orderItem);
				orderService.updatePrice(order, orderItem);
				orderService.save(order);
				return orderItem;
				// creo ordine e aggiungo orderitem
			}
			
		}
		
		return null;
	}
	
	
	/*
	public String purchase(@PathVariable Integer id, HttpSession session, Model model )
	{
		Product prod = productService.findById(id); /*JPAmanager.findProductById(id);
		User user = (User) session.getAttribute("user");
		Order order = (Order)session.getAttribute("order");
		OrderItem ordIt = new OrderItem();
		
		if(order==null)
		{
		order = new Order();
		order.setState("open");
		order.setUserId(user.getId());
		orderService.save(order);
		session.setAttribute("order",order);
		}
		
		ordIt = orderItemService.findByOrderIdAndProductId(order.getId(), id);
		if(ordIt!=null)
		{
			ordIt.setQuantity(ordIt.getQuantity()+1);
			ordIt.setAmount((ordIt.getQuantity())*(prod.getPrice()));
			orderItemService.save(ordIt);
			
			
		}
		else
		{
			ordIt = new OrderItem();
			ordIt.setOrderId(order.getId());
			ordIt.setProductId(id);
			ordIt.setQuantity(1);
			ordIt.setAmount(prod.getPrice());
			orderItemService.save(ordIt);
			
		}
		
		List<OrderItem> items = orderItemService.findAllByOrderId(order.getId());
		model.addAttribute("items",items);
		model.addAttribute("amount",orderItemService.totalAmount(order.getId()));
		 return "purchase_order";
	}
	 */
}
