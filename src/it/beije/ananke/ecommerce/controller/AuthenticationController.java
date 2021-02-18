package it.beije.ananke.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.ecommerce.Product;
import it.beije.ananke.ecommerce.User;
import it.beije.ananke.ecommerce.repository.ProductRepository;
import it.beije.ananke.ecommerce.repository.UserRepository;
import it.beije.ananke.ecommerce.service.AuthenticationService;
import it.beije.ananke.ecommerce.service.ProductService;

@Controller
public class AuthenticationController {

	@Autowired
	private AuthenticationService authService; 
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String email, @RequestParam String password, Model model) {
//		JPAmanager jpa = new JPAmanager();
//		if (jpa.authentication(email, password)){	
//			model.addAttribute("email", email);	
//			return products(model);
//		}else{
//			return"login";
//		}
//		User user = userRepository.findByEmailAndPassword(email, password);
		User user = authService.findByEmailAndPassword(email, password);
		if(user != null) {
			model.addAttribute("id", user.getId());
			List<Product> products = productService.findAll();
			model.addAttribute("products",products);
			
			return "products";
		}
		return "login";
	}
	
	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public String login() {		
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {		
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user) {
//		JPAmanager jpa = new JPAmanager();		
//		user.setName(user.getName());
//		user.setSurname(user.getSurname());
//		user.setEmail(user.getEmail());
//		user.setPassword(user.getPassword());
//		jpa.addUser(user);
//		return"login";
		authService.save(user);
		return"login";
	}
}
