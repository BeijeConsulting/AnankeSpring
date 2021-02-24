package it.beije.ananke.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.beije.ananke.repository.ContattoRepository;

@Controller
public class EcommerceControllerShopPage {
	
	@Autowired
	private ContattoRepository contattoRepository;
	
	//lui si occupa di mandare e aggiornare la pagina dello shop
	//visualizzare i prodotti
	//visualizzare il carrello
	
	//a ogni chiamata di aggiunta di un prodotto, prendo le info di tale prodotto, lo cerco nello shop
	//e lo aggiungo al model richiamando ancora la homepage
	
	//se vuoi però riaggiornare la stessa pagina, devi riprenderti 

}
