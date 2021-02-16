package it.beije.ananke.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.model.Product;
import it.beije.ananke.model.User;
import it.beije.ananke.repository.UserRepository;
import it.beije.ananke.service.UserService;
import it.beije.ananke.repository.ProductRepository;

@Controller
public class EcommerceDataController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductRepository pr;
	
	
	
	@RequestMapping(value = "/verifica", method = RequestMethod.POST)
	public String verificaLogin(@RequestParam String email, @RequestParam String password, Model model) {
		User user = userService.findByEmail(email);
		System.out.println("BELLA");
		model.addAttribute("user", user);
		
		if(user == null) {
			model.addAttribute("missing", "Utente non registrato");
			return "home";
		}else {
			if(password.equals(user.getPasword())) {
				model.addAttribute("errore", null);
				model.addAttribute("list", pr.findAll());
				return "schermataProdotti";
			}else {
				model.addAttribute("errore", "Autenticazione fallita");
				return "login";
			}
		}
	}
	
	
	@RequestMapping(value = "/verifica", method = RequestMethod.GET)
	public String verificaLogin(String email, String password, Model model, int i) {
		User user = userService.findByEmail(email);
		System.out.println("BELLA");
		
		if(user == null) {
			model.addAttribute("missing", "Utente non registrato");
			return "home";
		}else {
			if(password.equals(user.getPasword())) {
				model.addAttribute("user", user);
				model.addAttribute("errore", null);
				model.addAttribute("list", pr.findAll());
				return "schermataProdotti";
			}else {
				model.addAttribute("errore", "Autenticazione fallita");
				return "login";
			}
		}
	}
	

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public String signUp(@RequestParam String email, @RequestParam String password, @RequestParam String name_param , @RequestParam String surname_param, Model model) {
		User user = userService.signUp(email, password, name_param, surname_param);
		if(user == null) {
			model.addAttribute("errore", "Email già associata ad un account.");
			return "signUp";
		}else {
			model.addAttribute("errore", null);
			model.addAttribute("list", pr.findAll());
			model.addAttribute("user", user);
			return "schermataProdotti";
		}
	}
	
	
	@RequestMapping(value = "/aggiungi", method = RequestMethod.POST)
	public String aggiungiCarrello(String id) {
		System.out.print(id);
		return "carrello";
	}
}
