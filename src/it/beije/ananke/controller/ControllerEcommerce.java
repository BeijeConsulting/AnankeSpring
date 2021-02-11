package it.beije.ananke.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.ananke.ecommerce.Utente;

@Controller
public class ControllerEcommerce {
	
	@RequestMapping(value = "catalog", method = RequestMethod.GET)
	public String visualizzaCatalogo(HttpServletRequest request, Model model, Locale locale) {
		
		System.out.println("sono nella visualizza catalogo..." + request.getRequestURL() + 
									" - locale " + locale.getDisplayCountry());

		return "catalogo";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Locale locale) {
		return "login";
	}
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(Locale locale) {
		return "index";
	}
	
	@RequestMapping(value = "registrazione", method = RequestMethod.GET)
	public String registrazine(Locale locale) {
		return "registrazione";
	}
	
	@RequestMapping(value = "registrazione", method = RequestMethod.POST)
	public String registrazine(Utente u, Model model, Locale locale) {
		System.out.println("Servelt registrazione");
		String nome = u.getNome();
		String cognome = u.getCognome();
		String email = u.getEmail();
		String password = u.getPassword();
		
		if(Utente.cercaUtente(email) == true) {
			return "registrazioneError";
		} else {
			Utente.registraNuovoUtente(email, nome, cognome, password);
			return"registrazioneOk";
		}
	}
	
	
	

	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Utente u, Model model, Locale locale) {
		
		int id = Utente.login(u.getEmail(), u.getPassword());
		
		if(id != 0)
			return "catalogo";
		else
			return "loginError";
	}


}
