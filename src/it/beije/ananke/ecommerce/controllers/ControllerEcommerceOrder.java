package it.beije.ananke.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.beije.ananke.repository.ContattoRepository;

@Controller
public class ControllerEcommerceOrder {
	
	@Autowired
	private ContattoRepository contattoRepository;
	
	//che richieste fa? 
	//gestisce l'ordine di un cliente
	//quindi quando riceve i dati di un prodotto da aggiungere al carrello
	//prende i dati e li invia 

}
