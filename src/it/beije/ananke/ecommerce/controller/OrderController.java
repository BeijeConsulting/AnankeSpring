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

import it.beije.ananke.ecommerce.model.Chart;
import it.beije.ananke.ecommerce.model.Order;
import it.beije.ananke.ecommerce.model.OrderItem;
import it.beije.ananke.ecommerce.model.Product;
import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.model.dao.JpaDao;
import it.beije.ananke.ecommerce.repositories.ChartRepository;
import it.beije.ananke.ecommerce.repositories.OrderItemRepository;
import it.beije.ananke.ecommerce.repositories.OrderRepository;
import it.beije.ananke.ecommerce.repositories.ProductRepository;
import it.beije.ananke.ecommerce.service.ChartService;
import it.beije.ananke.ecommerce.service.OrderItemService;
import it.beije.ananke.ecommerce.service.OrderService;
import it.beije.ananke.ecommerce.service.ProductService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	ChartService chartService;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ChartRepository chartRepository;

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String addToChart(@RequestParam Integer id, @RequestParam Integer quantity, @RequestParam Double price,
			@RequestParam String name, @RequestParam String description, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		model.addAttribute("userId", user);
		model.addAttribute("products", productRepository.findAll());
		
		System.out.println(user==null);
		System.out.println(user.getEmail());
		
		if(user!=null) {
			Order order = orderService.openOrder(user);
			
			System.out.println(order == null);
			System.out.println(order.getId());
			
			OrderItem orderItem = orderItemService.addToChart(order.getId(), id, quantity, price);
			orderService.updatePrice(order, orderItem);
			System.out.println("here");
			Chart chart = chartService.addToChart(orderItem, name, description, user.getId());
			chartRepository.save(chart);
			System.out.println("fuori da chart");
		}
		return "products";
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String orders(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		List<Order> orders = orderService.findByUserId(user.getId());
		model.addAttribute("orders", orders);
		model.addAttribute("userId", user.getId());
		System.out.println("I'm showing orders");
		return "orders";
	}
	
//	@RequestMapping(value = "/orderItems", method = RequestMethod.POST)
//	public String orderItems(@RequestParam Integer id, HttpServletRequest request, Model model) {
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("user");
//		
//		List<Product> orderItems = orderItemService.showOrderItems(id);
//		model.addAttribute("orderItems", orderItems);
//		model.addAttribute("userId", user.getId());
//		return "orderItems";
//	}


	


	

	
}
