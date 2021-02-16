package it.beije.ananke.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import it.beije.ananke.model.Product;
import it.beije.ananke.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
	public String getAllProducts(Model model) {
		List<Product> allProducts = new ArrayList<>();
		allProducts = productService.findAll();
		model.addAttribute("allProducts", allProducts);
		return "getAllProducts";
	}
	
	@RequestMapping(value="/addProductGet", method = RequestMethod.GET)
	public String addProduct() {
		
		return "addProductForm";
	}
	@RequestMapping(value="/removeProductGet", method = RequestMethod.GET)
	public String removeProductGet() {
		
		return "removeProductGet";
	}
	@RequestMapping(value="/addProductPost", method = RequestMethod.POST)
	public String addProductPost(Product product) {
		productService.save(product);
		return "productAdded";
	}
	@RequestMapping(value="/removeProductPost", method = RequestMethod.DELETE)
	public String removeProductPost(@RequestParam String productName) {
		productService.remove(productName);
		return "productRemoved";
	}
}
