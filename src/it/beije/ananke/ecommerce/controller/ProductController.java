package it.beije.ananke.ecommerce.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.ecommerce.model.Product;
import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.repositories.ProductRepository;
import it.beije.ananke.ecommerce.repositories.UserRepository;
import it.beije.ananke.ecommerce.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		List<Product> products = productRepository.findAll();
		if(user!=null) {
			System.out.println(user.getEmail());
			model.addAttribute("products", products);
			model.addAttribute("userId", user.getId());
		}
		
		
		System.out.println("in show products");
		return "products";
	}
	
//	@RequestMapping(value = "/newProduct", method = RequestMethod.POST)
//	public String newProduct(@RequestParam String name, @RequestParam String description, 
//			@RequestParam Double price, HttpServletRequest request, Model model) {
//		productService.addProduct(name, description, price);
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("user");
//		model.addAttribute("userId", user.getId());
//		model.addAttribute("title", "admin");
//		return "home";
//	}
//	
	@RequestMapping(value = "/newProduct", method = RequestMethod.GET)
	public String newProduct(HttpServletRequest request) {
		System.out.println("Inserting new product...");
		return "newProduct";
	}
}
