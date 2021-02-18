package it.beije.ananke.ecommerce.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.ecommerce.Order;
import it.beije.ananke.ecommerce.OrderItem;
import it.beije.ananke.ecommerce.Product;
import it.beije.ananke.ecommerce.User;
import it.beije.ananke.ecommerce.repository.ProductRepository;
import it.beije.ananke.ecommerce.service.OrderService;
import it.beije.ananke.ecommerce.service.ProductService;

@Controller
public class ProductsController {
	
	@Autowired
	private ProductService productService;

	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(Model model) {
//		JPAmanager jpa = new JPAmanager();
//		List<Product> products = new ArrayList<>();
//		products = jpa.findAllProducts();
//		model.addAttribute("products",products);
//		return "products";
		
		List<Product> products = productService.findAll();
		model.addAttribute("products",products);
		return "products";
	}
	
	
}
