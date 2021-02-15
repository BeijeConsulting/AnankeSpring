package ecommerce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ecommerce.entity.User;
import ecommerce.model.JPAManager;
import ecommerce.repository.UserRepository;

@Controller
public class registrationController {
@Autowired
private UserRepository user_rep;
	
	@RequestMapping(value = "registrationPage", method = RequestMethod.GET)
	public String regPage() {
		
		System.out.println("registraion");
		return "registration";
	}
	
	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String registration(@RequestParam String fname, @RequestParam String lname , @RequestParam String email, @RequestParam String password, Model model) {
		User u = user_rep.findByEmail(email);
		if(u != null) {
			
		
			model.addAttribute("error","L'email è già stata inserita");
			return "registration";
		}else {
			u = new User();
			u.setName(fname);
			u.setLastName(lname);
			u.setEmail(email);
			u.setPassword(password);
			user_rep.save(u);
			
			return "login";
		}
	}
}
