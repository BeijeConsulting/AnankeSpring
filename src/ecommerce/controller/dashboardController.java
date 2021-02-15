package ecommerce.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ecommerce.entity.*;
import ecommerce.model.*;
import ecommerce.repository.OrderRepository;
import ecommerce.repository.Order_ItemRepository;
import ecommerce.repository.ProductRepository;
import ecommerce.repository.UserRepository;

@Controller
public class dashboardController {
	@Autowired
	private ProductRepository product_rep;
	@Autowired
	private OrderRepository order_rep;
	@Autowired UserRepository user_rep;
	
	
	
	@RequestMapping(value = "dashboard", method = RequestMethod.GET)
	public String adminpanel(Model model) {
		
		getDbDatas(model);
		return "admindashboard";
	}
	
	public void getDbDatas(Model model) {
		List<Product> p = product_rep.findAll();
		List<Order> o = order_rep.findAll();
		List<User> u = user_rep.findAll();
		model.addAttribute("products", p);
		model.addAttribute("orders", o);
		model.addAttribute("users", u);
	}
	
}
