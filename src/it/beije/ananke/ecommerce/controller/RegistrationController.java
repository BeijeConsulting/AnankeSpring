package it.beije.ananke.ecommerce.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.model.dao.JpaDao;
import it.beije.ananke.ecommerce.model.dao.JpaUser;

@Controller
public class RegistrationController {
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam String email, @RequestParam String password, 
			@RequestParam String firstName, @RequestParam String lastName) {
		
		System.out.println(firstName + lastName + email + password);
		JpaUser dao = new JpaUser();
		User u = new User();
		
		u.setEmail(email);
		u.setFirstName(firstName);
		u.setSecondName(lastName);
		u.setPassword(password);
		
		dao.register(u);
		
		System.out.println("Trying to register");
		return "home";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(HttpServletRequest request) {
		System.out.println("get registration...");
		return "register";
	}
	
	
}
