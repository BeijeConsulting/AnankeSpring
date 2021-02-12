package ecommerce.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ecommerce.entity.*;
import ecommerce.model.*;

@Controller
public class dashboardController {

	
	
	@RequestMapping(value = "dashboard", method = RequestMethod.GET)
	public String adminpanel(Model model) {
		
		getDbDatas(model);
		return "admindashboard";
	}
	
	public void getDbDatas(Model model) {
		List<Product> p = JPAManager.getAllProducts();
		List<Order> o = JPAManager.getAllOrders();
		List<User> u = JPAManager.getAllUsers();
		model.addAttribute("products", p);
		model.addAttribute("orders", o);
		model.addAttribute("users", u);
	}
	
}
