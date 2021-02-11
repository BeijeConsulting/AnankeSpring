package it.beije.ananke.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.ananke.model.JPAmanager;


@Controller
public class CommerceController {
	JPAmanager m = new JPAmanager();
	
	@RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	
	@RequestMapping(value = {"login"}, method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	
	@RequestMapping(value = {"signup"}, method = RequestMethod.GET)
	public String signup() {
		return "signup";
	}
	
	
	@RequestMapping(value = {"schermataProdotti"}, method = RequestMethod.POST)
	public String accedi(HttpServletRequest request, HttpServletResponse response) {
		
		return "schermataProdotti";
	}
}
