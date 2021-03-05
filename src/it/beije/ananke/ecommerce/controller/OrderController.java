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
		model.addAttribute("id", id);
		return "order";
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String orders(HttpSession session, Model model) {
		User userBean = (User)session.getAttribute("userBean");
		List<Order> orders = orderService.findByUserId(userBean.getId());
		model.addAttribute("orders", orders);
		return "orders";
	}
	
//	@RequestMapping(value = "/order", method = RequestMethod.POST)
//	public String order(@RequestParam int id, HttpSession session) {
//		Order order = orderService.findById(id);
//		order.setState("done");
//		orderService.save(order);
//		session.removeAttribute("orderBean");
//		order = (Order) session.getAttribute("orderBean");
//
//		return "success";
//	}
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String success(@RequestParam int id, HttpSession session) {
		Order order = orderService.findById(id);
		order.setState("done");
		orderService.save(order);
		session.removeAttribute("orderBean");
		order = (Order) session.getAttribute("orderBean");

		return "success";
	}
}
