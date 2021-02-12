package it.beije.ananke.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerEcommerceIdentification {
	
	@RequestMapping(value = { "/" , "ecommerce"} , method = RequestMethod.GET)
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
	public String postRegistration(HttpServletRequest request, Model model, Locale locale) {
		
		//prende i dati della registrazione prendendo direttamente un'istanza user
		//con l'istanza user, inserisco nel db l'utente, a meno che non sia già registrato 
		//con la stessa mail
		
		//INOLTRE email e pw devono essere NOT NULL
		//fai qui il controllo. se uno dei due è null, rimanda ancora alla pagina di registrazione. 
		//visualizza un messaggio appena capisci come fare
		
		//una volta registrato, gli permetto di accedere
		
		return "ecommerceLogIn";
		
	}
	
	@RequestMapping(value = "/ecommerce/logIn", method = RequestMethod.GET)
	public String getLogIn(HttpServletRequest request, Model model, Locale locale) {
		
		//ti manda alla pagina di logIn
		
		return "ecommerceLogIn";
		
	}
	
	@RequestMapping(value = "/ecommerce/logIn", method = RequestMethod.POST)
	public String postLogIn(HttpServletRequest request, Model model, Locale locale) {

		//prende i dati del log in, chiama una funzione che fa una select al db
		//se trova l'utente allora è identificato e lo mette nella sessione
		
		//lo porta alla pagina dell'ecommerce con i prodotti etc
		
		//TODO: qui metto la chiamata per prendermi la lista di prodotti e 
		//		aggiungerla al model per poterla visualizzare nella 
		//		ecommerceHomePage
		
		return "ecommerceHomePages";
		
	}

}
