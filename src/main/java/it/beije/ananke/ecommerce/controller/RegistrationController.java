package it.beije.ananke.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.repositories.UserRepository;

@Controller
public class RegistrationController {
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam String email, @RequestParam String password, 
			@RequestParam String firstName, @RequestParam String lastName) {
		System.out.println(firstName + lastName + email + password);
		
		User u = new User();
		
		u.setEmail(email);
		u.setFirstName(firstName);
		u.setSecondName(lastName);
		u.setPassword(password);
		
		userRepository.save(u);
		
		System.out.println("Trying to register");
		return "home";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(HttpServletRequest request) {
		System.out.println("get registration...");
		return "register";
	}
	
	
}
