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
import ecommerce.services.UserService;

@Controller
public class registrationController {
@Autowired
private UserService user_serv;
	
	@RequestMapping(value = "registrationPage", method = RequestMethod.GET)
	public String regPage() {
		return "registration";
	}
	
	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String registration(@RequestParam String fname, @RequestParam String lname , @RequestParam String email, @RequestParam String password, Model model) {
    if(user_serv.addUser(fname, lname, email, password)) {
    return "login";
	}else {
		model.addAttribute("state", "Attenzione, l'email è già stata inserita");
		return "registration";
	}
	}
}
