package it.beije.ananke.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.ecommerce.model.Order;
import it.beije.ananke.ecommerce.model.OrderItem;
import it.beije.ananke.ecommerce.model.Product;
import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.model.dao.JpaDao;
import it.beije.ananke.ecommerce.repositories.OrderItemRepository;
import it.beije.ananke.ecommerce.repositories.OrderRepository;
import it.beije.ananke.ecommerce.repositories.ProductRepository;
import it.beije.ananke.ecommerce.service.OrderItemService;
import it.beije.ananke.ecommerce.service.OrderService;
import it.beije.ananke.ecommerce.service.ProductService;
import it.beije.ananke.ecommerce.service.UserService;
import it.beije.ananke.ecommerce.util.OrderState;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String orders(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			return "home";
		}
		List<Order> orders = orderService.findByUserId(user.getId());
		model.addAttribute("orders", orders);
		model.addAttribute("userId", user.getId());
		System.out.println("I'm showing orders");
		return "orders";
	}
	
	@RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(@RequestParam Integer id, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		model.addAttribute("userId", user.getId());
		Order order = orderRepository.findById(id).get();
		order.setState(OrderState.CLOSED);
		orderRepository.save(order);
//		chartRepository.deleteByOrderId(id);
		return "orders";
	}


	


	

	
}
