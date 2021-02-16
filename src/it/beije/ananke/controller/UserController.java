package it.beije.ananke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.model.User;
import it.beije.ananke.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	

	@RequestMapping(value = "/start", method = RequestMethod.GET)
	public String getString() {
		return "mainPage";
	}
	@RequestMapping(value = "/loginFormGet", method = RequestMethod.GET)
	public String loginForm() {
		return "loginForm";
	}
	@RequestMapping(value = "/userLoggedIn", method = RequestMethod.POST)
	public String userLoggedIn(@RequestParam String email, @RequestParam String password) {
		
		User user = userService.findByEmail(email);
		
	
		if(user!= null && user.getEmail().equalsIgnoreCase(email) && user.getPassword().equalsIgnoreCase(password)) {
			return "userPersonalPage";
		}
		else {
		return "userLogInFailed";
		}
	}

	@RequestMapping(value = "/registrationForm", method = RequestMethod.GET)
	public String form() {
		System.out.println("get form...");
		return "registrationForm";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String postContatto(User user, Model model) {
		System.out.println("postContatto : " + user);
		userService.save(user);
		model.addAttribute("user", user);
		return "done";
	}
	
	
	public String logOut() {
		
		return null;
	}

}
