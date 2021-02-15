package it.beije.ananke.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.ananke.entity.Product;
import it.beije.ananke.model.JPAManager;

@Controller
public class ProductController {
	
	JPAManager managerJPA = new JPAManager();
	
	@RequestMapping(value = "/prodotti", method = RequestMethod.GET)
	public String listaProdotti(Model model) {
		
		List<Product> products = managerJPA.getProducts();
		
		model.addAttribute("products", products);
		
		System.out.println(products);
		
		Product prodotto = products.get(0);
		
		System.out.println(prodotto.getName() + " " + prodotto.getDesc());
		
		return "prodotti";
		
	}
	

}
