package it.beije.ananke.ecommerce.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.ecommerce.model.Product;
import it.beije.ananke.ecommerce.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ProductRestController {
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/products")
	public @ResponseBody List<Product> showProducts() {
		System.out.println("chiamata a showProducts in productRestController");
		return productService.findAll();
	}
}
