package it.beije.ananke.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.model.JPAManager;

@Controller
public class LoginController {
	
	JPAManager managerJPA = new JPAManager();
	
	@RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model, Locale locale) {
		
		System.out.println("Index page" + request.getRequestURL() + " - locale " + locale.getDisplayCountry());
		
		String saluto = "Buongiorno";
		model.addAttribute("saluto", saluto);
		
		return "login";
		
	}
	
	
	@RequestMapping(value = "/registrazione", method = RequestMethod.GET)
	public String registrazione() {
		
		return "registrazione";
		
	}
	
	/*
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String form(@RequestParam(required = false) String nome, @RequestParam String cognome, HttpServletRequest request, Model model) {
		System.out.println("post form...");
		
		//String nome = request.getParameter("nome");
		//String cognome = request.getParameter("cognome");
		
		model.addAttribute("nome", nome);
		model.addAttribute("cognome", cognome);
		
		return "dati";
	}
	*/
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String nome, @RequestParam String password, Model model) {
		
		model.addAttribute("nome", nome);
		model.addAttribute("password", password);
		
		boolean verifica = managerJPA.verificaUtenteDb(nome, password);
		
		model.addAttribute("error", "Email e/o passord errate");
		
		if(verifica) {
			
			return "home";
			
		}else return "login";

		
	}
	

}
