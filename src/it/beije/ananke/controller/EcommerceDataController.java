package it.beije.ananke.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.model.User;

public class EcommerceDataController {
	
	@RequestMapping(value = {"signUp"}, method = RequestMethod.POST)
	public String registrazione(@RequestParam String email, @RequestParam String password, @RequestParam String name_param , @RequestParam String surname_param , HttpServletRequest request, Model model) {
		return "";
	}
	
	
	@RequestMapping(value = {"verificaLogin"}, method = RequestMethod.POST)
	public String verificaLogin(@RequestParam String email, @RequestParam String password, HttpServletRequest request, Model model) {
		return "";
	}
	
	
	@RequestMapping(value = {"aggiungi"}, method = RequestMethod.POST)
	public String aggiungiCarrello() {
		
		return "carrello";
	}
}
