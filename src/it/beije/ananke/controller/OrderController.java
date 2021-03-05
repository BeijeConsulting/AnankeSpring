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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.ananke.entity.Order;
import it.beije.ananke.entity.OrderItem;
import it.beije.ananke.entity.Product;
import it.beije.ananke.entity.User;
import it.beije.ananke.service.OrderItemService;
import it.beije.ananke.service.OrderService;
import it.beije.ananke.service.ProductService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired 
	private ProductService productService;
	
	@Autowired 
	private OrderItemService orderItemService;

	@RequestMapping(value ="/orderHistory", method = RequestMethod.GET)
	public String myOrders(HttpServletRequest request, Model model, HttpSession session)
	{
		User utente = (User)session.getAttribute("user");
		List<Order> orders = orderService.findByUserId(utente.getId());/*JPAmanager.findOrderByUser(utente.getId());*/
		
		model.addAttribute("orders",orders);
		
		return "my_orders";
	}
	
	@GetMapping(value = "/cart")
	public String cart(HttpSession session, Model model)
	{
		User user = (User) session.getAttribute("user");	
		Order order = orderService.findByUserIdAndOrderOpen(user.getId(), "open");
		
		if(order!=null)
		{
			session.setAttribute("order",order);
			List<OrderItem> items = orderItemService.findAllByOrderId(order.getId());
			model.addAttribute("items",items);
			model.addAttribute("amount",orderItemService.totalAmount(order.getId()));
			
			return "carrello";
		}
		else  return "carrello";
	}
	
	@GetMapping(value = "/purchase/{id}")
	public String purchase(@PathVariable Integer id, HttpSession session, Model model )
	{
		Product prod = productService.findById(id); /*JPAmanager.findProductById(id);*/
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
	
	@GetMapping(value="/continuaAcquisto")
	public String continuaAcquisto()
	{
		return "index";
	}
	
	@GetMapping(value="/confermaAcquisto")
	public String confemaAcquisto(HttpSession session)
	{
		Order order = (Order)session.getAttribute("order");
		
		Order ord = orderService.findById(order.getId());
				
		ord.setAmount(orderItemService.totalAmount(order.getId()));
		ord.setState("close");
		
		orderService.save(ord);
		
		session.setAttribute("order",null);
		
		return "confermato";
	}
	
	@GetMapping(value="/annullaOrdine")
	public String annullaOrdine(HttpSession session)
	{
		Order order = (Order) session.getAttribute("order");	
		
		order.setAmount(orderItemService.totalAmount(order.getId()));
		orderItemService.deleteByOrderId(order.getId());		
		orderService.updateStatus(order.getId());
		session.setAttribute("order",null);
		
		return "index";
	}
}
