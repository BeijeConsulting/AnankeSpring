package it.beije.ananke.ecommerce.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.ananke.ecommerce.beans.User;
import it.beije.ananke.repository.ContattoRepository;

@Controller
public class ControllerEcommerceOrder {
	
	@Autowired
	private ContattoRepository contattoRepository;
	
	//che richieste fa? 
	//gestisce l'ordine di un cliente
	//quindi quando riceve i dati di un prodotto da aggiungere al carrello
	//prende i dati e li invia 
	
	@RequestMapping(value = "/ecommerce/addOrder", method = RequestMethod.POST)
	public String postAddProduct(User user, Model model, HttpSession session) {
		
		return "ecommerceHomePage";
	}

}
