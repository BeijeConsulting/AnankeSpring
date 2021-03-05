package it.beije.ananke.ecommerce.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.ecommerce.Product;
import it.beije.ananke.ecommerce.service.ProductService;

@Controller
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductsRestController {
	
	@Autowired
	private ProductService productService;
	

	@GetMapping(value = "/products")
	public List<Product> products(Model model) {

		List<Product> products = productService.findAll();
		model.addAttribute("products",products);
		return products;
	}

}
