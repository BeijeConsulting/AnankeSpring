package it.beije.ananke.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.entity.Product;
import it.beije.ananke.entity.User;
import it.beije.ananke.model.JPAmanager;
import it.beije.ananke.repository.UserRepository;
import it.beije.ananke.service.UserService;

@Controller
public class UtenteController {
	
	@Autowired
	private UserService userService;
	

	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model) {
			
		return "index";
	}
	
	@RequestMapping(value="/register")
	public String register()
	{
		return "registration_form";
	}
	
	@RequestMapping(value="/registerForm", method = RequestMethod.POST)
	public String registerForm(User user)
	{
		User utente = userService.findByEmail(user.getEmail());/*JPAmanager.findUserByEmail(user.getEmail());*/
		
		if(utente!=null)
		{
			return "registration_form";
		}
		else {
				userService.save(user);
				//JPAmanager.addUser(user);
			
				return "index";
		}	
	}
	
	@RequestMapping(value="/login")
	public String login()
	{
		return "login_form";
	}
	
	@RequestMapping(value="/loginForm", method = RequestMethod.POST)
	public String loginForm(@RequestParam String email, @RequestParam String password, HttpSession session)
	{
		User utente = userService.findByEmail(email);/*JPAmanager.findUserByEmail(email);*/
		
		if(utente!=null)
		{
			if(utente.getPassword().equals(password))
			{
				session.setAttribute("user", utente);
				
				return "index";
			}
			else return "login_form";
		}
		else return "error_login";		
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session)
	{		
		session.invalidate();
		
		return "index";
	}
	
	@GetMapping(value="/cantPurchase")
	public String cantPurchase()
	{
		return "cantPurchase";
	}
	
	
}
