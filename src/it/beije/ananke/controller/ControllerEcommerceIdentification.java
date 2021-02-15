package it.beije.ananke.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beje.ananke.ecommerce.JPAUsers;
import it.beje.ananke.ecommerce.User;

@Controller
public class ControllerEcommerceIdentification {
	
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
		
		//prende i dati della registrazione prendendo direttamente un'istanza user
		//con l'istanza user, inserisco nel db l'utente, a meno che non sia già registrato 
		//con la stessa mail
		StringBuilder message = new StringBuilder();
		
		if(user.getEmail() == null) {
			message.append("E' necessario inserire una mail");
			
		}
		if(user.getPassword() == null){
			message.append("E' necessario inserire una password");
		}
		
		if((user.getEmail() == null) && (user.getPassword() == null)) {
			if(JPAUsers.registerUser(user))
				return "ecommerceLogIn";
			else {
				message.append("Sei già stato restrato al nostro e.commerce con questa mail");
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
	public String postLogIn(User user, Model model) {
		
		StringBuilder message = new StringBuilder();
		//prende i dati del log in, chiama una funzione che fa una select al db
		//se trova l'utente allora è identificato e lo mette nella sessione
		if(JPAUsers.userIsRegisted(user)) {
			if(JPAUsers.logInUser(user)) {
				message.append("Registrazione avvenuta con successo! Benvenuto nel nostro ecommerce");
				model.addAttribute("message", message.toString());
				return "ecommerceHomePage";
			}
			else {
				message.append("C'è stato un problema durante il riconoscimento, controlla di aver inserito la password corretta");
				model.addAttribute("message", message.toString());
				return "ecommerceLogIn";
			}
		}
		else {
			message.append("Mi dispiace ma non sei registrato al nostro sito!");
			model.addAttribute("message", message.toString());
			return "ecommerceRegistration";
		}
		
		
	}

}
