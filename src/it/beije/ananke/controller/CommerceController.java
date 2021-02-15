package it.beije.ananke.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.model.JPAmanager;
import it.beije.ananke.model.User;


@Controller
public class CommerceController {
	JPAmanager m = new JPAmanager();
	
	@RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	
	@RequestMapping(value = {"signup"}, method = RequestMethod.GET)
	public String signup(HttpServletRequest request) {
		return "signup";
	}
	
	
	@RequestMapping(value = {"signUp"}, method = RequestMethod.POST)
	public String registrazione(@RequestParam String email, @RequestParam String password, @RequestParam String name_param , @RequestParam String surname_param , HttpServletRequest request, Model model) {
		User user = m.login(email);
		if(user == null) {
			return "home";
		}else {
			model.addAttribute("list", m.letturaProdotti());
			return "schermataProdotti";
		}
	}
	
	
	@RequestMapping(value = {"login"}, method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	
	@RequestMapping(value = {"verificaLogin"}, method = RequestMethod.POST)
	public String verificaLogin(@RequestParam String email, @RequestParam String password, HttpServletRequest request, Model model) {
		User user = m.login(email);
		model.addAttribute("user", user);
		if(user == null) {
			model.addAttribute("missing", "Utente non registrato");
			return "home";
		}else {
			if(user.getPasword().equals(password)) {
				model.addAttribute("list", m.letturaProdotti());
				return "schermataProdotti";
			}else {
				model.addAttribute("flag", false);
				
				return "login";
			}
		}
	}
	
	
	@RequestMapping(value = {"aggiungi"}, method = RequestMethod.POST)
	public String aggiungiCarrello() {
		
		return "carrello";
	}
}
