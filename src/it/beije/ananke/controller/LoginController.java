package it.beije.ananke.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.service.UserService;

@Controller
public class LoginController {
	
	// JPAManager managerJPA = new JPAManager();
	
	/*
	@Autowired
	private UserRepository userRepository;
	*/
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String index(HttpServletRequest request, Model model, Locale locale) {
		
		System.out.println("Index page" + request.getRequestURL() + " - locale " + locale.getDisplayCountry());
		
		String saluto = "Buongiorno";
		model.addAttribute("saluto", saluto);
		
		return "login";
		
	}
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(Model model) {
		
		return "home";
		
	}
	
	
	@RequestMapping(value = "/registrazione", method = RequestMethod.GET)
	public String formRegistrazione() {
		
		return "registrazione";
		
	}
	
	@RequestMapping(value = "/registrazione", method = RequestMethod.POST)
	public String registrazione(@RequestParam String email, @RequestParam String nome, @RequestParam String cognome, @RequestParam String password, Model model) {
		
		// managerJPA.inserisciUtenteDb(email, nome, cognome, password);
		
		userService.save(email, nome, cognome, password);
		
		model.addAttribute("registrazione", "Hai effettutato la registrazione correttamente");
		
		return "login";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String nome, @RequestParam String password, Model model) {
		
		model.addAttribute("nome", nome);
		model.addAttribute("password", password);
		
		// boolean verifica = managerJPA.verificaUtenteDb(nome, password);
		
		boolean verifica = userService.verificaUtente(nome, password);
		
		model.addAttribute("error", "Email e/o passord errate");
		
		if(verifica) {
			
			return "home";
			
		}else return "login";

		
	}
	

}
