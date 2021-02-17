package ecommerce.controller;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import ecommerce.entity.*;
import ecommerce.model.JPAManager;

import ecommerce.services.*;

@Controller
public class LoginController {
	
@Autowired
private UserService user_service;
@Autowired
private OrderService order_service;
@Autowired
private Order_ItemService orderitem_service;
	
	@RequestMapping(value ="loginPage", method = RequestMethod.GET)
	public String loginPage() {
		System.out.println("ci sono");
		return "login";
	}
	
	@RequestMapping(value ="auth", method = RequestMethod.POST)
	public String auth(@RequestParam String email, @RequestParam String password, Model model, HttpServletRequest request, HttpServletResponse response ) {
		User u = user_service.findByEmailAndPassword(email, password);
		if( u != null) {
			 
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			System.out.println(u.getEmail());
			List<Order> orders = order_service.findAllByUserId(u.getId());
			
			session.setAttribute("orders", orders);
			
			return "index";
			
		} else {
		model.addAttribute("error", "Email o Password sbagliate, riprova oppure");
			
			return "login";
			
		}
	}
	@RequestMapping(value ="logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("cart_item");
		session.invalidate();
		return "index";
	}
	
}
