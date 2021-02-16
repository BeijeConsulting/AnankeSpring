package it.beije.ananke.ecommerce.controller;

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

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	ProductRepository productRepository;

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String addToChart(@RequestParam Integer id, @RequestParam Integer quantity, @RequestParam Double price,
			HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		System.out.println(session==null);
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
			orderItemRepository.save(orderItem);
			orderService.updatePrice(order, orderItem);
		}
		return "products";
	}

	
}
