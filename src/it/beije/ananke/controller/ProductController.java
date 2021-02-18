package it.beije.ananke.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.entity.Product;
import it.beije.ananke.service.ProductService;

@Controller
public class ProductController {
	
	// JPAManager managerJPA = new JPAManager();
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/prodotti", method = RequestMethod.GET)
	public String listaProdotti(Model model) {
		
		// List<Product> products = managerJPA.getProducts();
		
		List<Product> products = productService.findAll();
		
		model.addAttribute("products", products);
		
		System.out.println(products);
		
		Product prodotto = products.get(0);
		
		System.out.println(prodotto.getName() + " " + prodotto.getDescription());
		
		return "prodotti";
		
	}
	
	@GetMapping("/aggiungiProdotto")
	public String aggiungiProdotto() {
		
		return "form-prodotto";
		
	}
	
	
	@PostMapping("/inserisci")
	public String inserisci(@RequestParam String nome, @RequestParam String descrizione, @RequestParam double prezzo, Model model) {
		
		productService.save(nome, descrizione, prezzo);
		
		List<Product> prodotti = productService.findAll();
		
		model.addAttribute("products", prodotti);
		
		return "prodotti";
	}
	
	@GetMapping("/eliminaProdotto")
	public String eliminaProdotto() {
		
		return "form-elimina-prodotto";
		
	}
	
	@PostMapping("/elimina")
	public String elimina(@RequestParam int id, Model model) {
		
		boolean eliminato = productService.removeById(id);
		
		if (eliminato) {
			
			List<Product> prodotti = productService.findAll();
			
			model.addAttribute("products", prodotti);
			model.addAttribute("conferma", "il prodotto n° " + id + " è stato rimosso correttamente");
			
			return "prodotti";
			
		}
		
		if (!eliminato) {
			
			model.addAttribute("errore", "hai inserito un id non valido");
			
			return "form-elimina-prodotto";
			
		}
		
		return "form-elimina-prodotto";
		
	}
	


}
