package it.beije.ananke.ecommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.ananke.ecommerce.model.OrderItem;
import it.beije.ananke.ecommerce.model.dao.JpaDao;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		System.out.println("In home");
		return "home";
	}
	
}
