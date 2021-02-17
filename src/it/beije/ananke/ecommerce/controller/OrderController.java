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
	public String order(@RequestParam int id, @RequestParam int qnt, Model model, HttpSession session) {
		
		//creo un nuovo ordine o prendo l'ordine in corso
		Order orderBean = (Order) session.getAttribute("orderBean");
		User userBean = (User) session.getAttribute("userBean");
		Integer userId = userBean.getId();
		orderBean.setUserId(id);
		orderBean.setState("in progress");
		Order order = orderService.save(orderBean, userId);
		
		//creo l'orderItem
		Product product = productService.findById(id);
		OrderItem orderItem = new OrderItem();
		orderItem.setQuantity(qnt);
		orderItem.setProduct_id(id);
		orderItem.setOrder_id(order.getId());
		orderItem.setAmount(qnt * product.getPrice());
		orderService.save(orderItem);
		
		
		//TO DO: order.setAmount
		
		List<OrderItem> orderItems = orderService.findByOrder(order.getId());
		model.addAttribute("orderItems", orderItems);
		//model.addAttribute("product", product);
		//model.addAttribute("qnt", qnt);
		//model.addAttribute("orderItem", orderItem);
		
		return "order";
	}
}
