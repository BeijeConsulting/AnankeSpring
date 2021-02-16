package it.beije.ananke.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.repositories.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String email, @RequestParam String password, 
			HttpServletRequest request, Model model) {
		User u = userRepository.findByEmail(email);
		model.addAttribute("userId", u.getId());
		HttpSession session = null;
		if(u!=null) {
			if(u.getPassword().equals(password)) {
				System.out.println("Welcome " + u.getFirstName());
				session = request.getSession();
				session.setAttribute("user", u);
				return "home";
			}
		}
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login (HttpServletRequest request) {
		System.out.println("get login...");
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout (HttpSession session) {
		System.out.println("get logout...");
		session.removeAttribute("user");
		return "home";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout (HttpServletRequest request) {
		System.out.println("get logout...");
		return "home";
	}
}
