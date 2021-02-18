package it.beije.ananke.ecommerce.controller;

import java.util.ArrayList;
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
import it.beije.ananke.ecommerce.repository.OrderRepository;
import it.beije.ananke.ecommerce.service.OrderService;
import it.beije.ananke.ecommerce.service.ProductService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String order(@RequestParam int id, Model model) {	
		List<OrderItem> orderItems = orderService.findByOrder(id);
		Order order = orderService.findById(id);
		model.addAttribute("orderItems", orderItems);
		model.addAttribute("total", order.getAmount());
		return "order";
	}
}
