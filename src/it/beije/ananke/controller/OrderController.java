package it.beije.ananke.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.ananke.entity.Order;
import it.beije.ananke.entity.OrderItem;
import it.beije.ananke.entity.Product;
import it.beije.ananke.entity.User;
import it.beije.ananke.model.JPAmanager;
import it.beije.ananke.repository.OrderItemRepository;
import it.beije.ananke.repository.OrderRepository;
import it.beije.ananke.repository.ProductRepository;

@Controller
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired 
	private ProductRepository productRepository;
	
	@Autowired 
	private OrderItemRepository orderItemRepository;

	@RequestMapping(value ="/orderHistory", method = RequestMethod.GET)
	public String myOrders(HttpServletRequest request, Model model, HttpSession session)
	{
		User utente = (User)session.getAttribute("user");
		List<Order> orders = orderRepository.findByUserId(utente.getId());/*JPAmanager.findOrderByUser(utente.getId());*/
		
		model.addAttribute("orders",orders);
		
		return "my_orders";
	}
	
	@RequestMapping(value = "/purchase/{id}")
	public String purchase(@PathVariable Integer id, HttpSession session, Model model )
	{
		Product prod = productRepository.findById(id).get(); /*JPAmanager.findProductById(id);*/
		User user = (User) session.getAttribute("user");
		Order order = (Order)session.getAttribute("order");
		OrderItem ordIt = new OrderItem();
		
		if(order==null)
		{
		order = new Order();
		order.setState("open");
		order.setUserId(user.getId());
		orderRepository.save(order);
		session.setAttribute("order",order);
		}
		
		ordIt = orderItemRepository.findByOrderIdAndProductId(order.getId(), id);
		if(ordIt!=null)
		{
			ordIt.setQuantity(ordIt.getQuantity()+1);
			ordIt.setAmount((ordIt.getQuantity())*(prod.getPrice()));
			orderItemRepository.save(ordIt);
		}
		else
		{
			ordIt = new OrderItem();
			ordIt.setOrderId(order.getId());
			ordIt.setProductId(id);
			ordIt.setQuantity(1);
			ordIt.setAmount(prod.getPrice());
			orderItemRepository.save(ordIt);
		}
		
		List<OrderItem> items = orderItemRepository.findAllByOrderId(order.getId());
		model.addAttribute("items",items);
		
		 return "purchase_order";
	}
	
	@RequestMapping(value="/continuaAcquisto")
	public String continuaAcquisto()
	{
		return "index";
	}
	
	@RequestMapping(value="/confermaAcquisto")
	public String confemaAcquist(HttpSession session)
	{
		Order order = (Order)session.getAttribute("order");
		
		Order ord = orderRepository.findById(order.getId()).get();
		
		ord.setState("close");
		
		orderRepository.save(ord);
		
		session.setAttribute("order",null);
		
		return "confermato";
	}
}
