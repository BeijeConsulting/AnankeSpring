package it.beije.ananke.ecommerce.controllers;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.ananke.ecommerce.EcommerceException;
import it.beije.ananke.ecommerce.beans.Product;
import it.beije.ananke.ecommerce.beans.User;
import it.beije.ananke.ecommerce.jpa.JPAUsers;
import it.beije.ananke.ecommerce.repositories.EcommerceRepositoryProduct;
import it.beije.ananke.ecommerce.repositories.EcommerceRepositoryUser;
import it.beije.ananke.ecommerce.services.EcommerceServiceUser;

@Controller
public class ControllerEcommerceIdentification {
	
	@Autowired
	private EcommerceRepositoryUser repoUser;
	
	@Autowired
	private EcommerceServiceUser serviceUser;
	
	@Autowired
	private EcommerceRepositoryProduct repoProduct;
	
	@RequestMapping(value = "/ecommerce" , method = RequestMethod.GET)
	public String indexEcommerce(HttpServletRequest request, Model model, Locale locale) {
		
		//richiesta in get che ti manda alla pagina dove accedere/registrarti
		
		return "ecommerceIndex";
		
	}
	
	@RequestMapping(value = "/ecommerce/registration", method = RequestMethod.GET)
	public String getRegistration(HttpServletRequest request, Model model, Locale locale) {
		
		//ti manda alla pagina di registrazione
		
		return "ecommerceRegistration";
		
	}
	
	@RequestMapping(value = "/ecommerce/registration", method = RequestMethod.POST)
	public String postRegistration(User user, Model model) {
		
		StringBuilder message = new StringBuilder();
		
		if((user.getEmail().length() != 0) && (user.getPassword().length() != 0)) {
			
			try {
				serviceUser.save(user);
				message.append("Benvenuto nel nostro e-commerce!");
			} catch (EcommerceException e) {
				message.append(e.getMessage());
			}
			
			model.addAttribute("message", message.toString());
			
			return "ecommerceLogIn";
		}
		else {
			
			if(user.getEmail().length() == 0) {
				message.append("E' necessario inserire una mail\n");
			}
			
			if(user.getPassword().length() == 0){
				message.append("E' necessario inserire una password");
			}
			
		}
		
		model.addAttribute("message", message.toString());
	
		return "ecommerceRegistration";
	}
	
	@RequestMapping(value = "/ecommerce/logIn", method = RequestMethod.GET)
	public String getLogIn(HttpServletRequest request, Model model, Locale locale) {
		
		//ti manda alla pagina di logIn
		
		return "ecommerceLogIn";
		
	}
	
	@RequestMapping(value = "/ecommerce/homePage", method = RequestMethod.POST)
	public String postLogIn(User user, Model model, HttpSession session) {
		
		StringBuilder message = new StringBuilder();
		
		if((user.getEmail().length() != 0) && (user.getPassword().length() != 0)) {
			
			User userDB = repoUser.findByEmail(user.getEmail());
			
			if(userDB != null) {
				
				//ho trovato l'user
				if(user.getPassword().equals(userDB.getPassword())) {
			
					session.setAttribute("user", userDB);
					//session.invalidate();
					//session.getAttribute("user");
					
					model.addAttribute("firstName", userDB.getFirstName());
					
					serviceUser.setAllProductToModel(model);
					model.addAttribute("seeCart", false);
					
					return "ecommerceHomePage";
					
				}
				else {
					message.append("La password non corrisponde. Controlla il BLOCK MAIUSCOLO");
				}
			}
			else {
				message.append("Non sei stato trovato nel DataBase. Controlla la mail o registrati!");
			}
			
		}
		else {
			if(user.getEmail().length() == 0) {
			message.append("E' necessario inserire una mail\n");
			
			}
			if(user.getPassword().length() == 0){
				message.append("E' necessario inserire una password");
			}
		}
		
	
		model.addAttribute("message", message.toString());
	
		return "ecommerceLogIn";
		
	}

	@RequestMapping(value = "/logOut", method = RequestMethod.GET)
	public String getLogOut(Model model, HttpSession session) {
		
		//tolgo tutto il toglibile dalla sessione
		session.invalidate();
		
		//al massimo far vedere un messaggio di buona uscita. 
		
		return "ecommerceIndex";
	}
}
