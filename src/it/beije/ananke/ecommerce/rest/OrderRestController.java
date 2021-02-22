package it.beije.ananke.ecommerce.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.ecommerce.Order;
import it.beije.ananke.ecommerce.OrderItem;
import it.beije.ananke.ecommerce.service.OrderService;

@Controller
@RestController
@RequestMapping("/api")
public class OrderRestController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping(value = "/order")
	public List<OrderItem> order(@RequestParam int id) {	
		List<OrderItem> orderItems = orderService.findByOrder(id);
		return orderItems;
	}
	
	@GetMapping(value = "/orders")
	public List<Order> orders(@RequestParam int id) {	
		List<Order> order = orderService.findByUserId(id);
		return order;
	}
	
	@PutMapping(value = "/success")
	public Order success(@RequestParam int id) {
		Order order = orderService.findById(id);
		order.setState("done");
		return orderService.save(order);
	}

}
