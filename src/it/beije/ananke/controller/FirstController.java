package it.beije.ananke.controller;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.dao.UserManager;
import it.beije.ananke.dao.UsersInJpaManager;
import it.beije.ananke.model.User;


@Controller
public class FirstController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getString() {
		
		  
		return "mainPage";
	}
	
//	@RequestMapping(value = "/form", method = RequestMethod.POST)
//	public String form(@RequestParam(required = false) String nome, @RequestParam String cognome, HttpServletRequest request, Model model) {
//		System.out.println("post form...");
//		
//		//String nome = request.getParameter("nome");
//		//String cognome = request.getParameter("cognome");
//		
//		model.addAttribute("nome", nome);
//		model.addAttribute("cognome", cognome);
//		
//		return "dati";
//	}
	
	@RequestMapping(value = "registration", method =  RequestMethod.POST )
	public String setData(@RequestParam String firstName, @RequestParam String lastName ,
			@RequestParam String email, @RequestParam String password ,Model model) throws IOException, SQLException {
		
		System.out.println("post method called.....");
		 User user = new User(firstName,lastName,email,password);
		  UserManager userManager = new UsersInJpaManager();
		  userManager.setUser(user);	
		return "done";
	}
	
}
