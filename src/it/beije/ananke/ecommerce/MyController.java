package it.beije.ananke.ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.model.Contatto;


@Controller
public class MyController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String email, @RequestParam String password, Model model) {
		JPAmanager jpa = new JPAmanager();
		if (jpa.authentication(email, password)){	
			model.addAttribute("email", email);	
			return products(model);
		}else{
			return"login";
		}
	}
	
	@RequestMapping(value = {"/","/login"}, method = RequestMethod.GET)
	public String index() {		
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {		
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user) {
		JPAmanager jpa = new JPAmanager();		
		user.setName(user.getName());
		user.setSurname(user.getSurname());
		user.setEmail(user.getEmail());
		user.setPassword(user.getPassword());
		jpa.addUser(user);
		return"login";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(Model model) {
		JPAmanager jpa = new JPAmanager();
		List<Product> products = new ArrayList<>();
		products = jpa.findAllProducts();
		model.addAttribute("products",products);
		return "products";
	}
	
	@RequestMapping(value = "/product-details", method = RequestMethod.GET)
	public String details(@RequestParam int id, Model model) {
		JPAmanager jpa = new JPAmanager();
		Product product = new Product();
		product = jpa.findProduct(id);
		model.addAttribute("product", product);
		return "product-details";
	}
	
	@RequestMapping(value = "/product-details", method = RequestMethod.POST)
	public String details(@RequestParam int id, @RequestParam int qnt, Model model) {	
		model.addAttribute("productId", id);
		model.addAttribute("qnt", qnt);
		return "order";
	}
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String order(@RequestParam int id, Model model) {
		return "order";
	}
}
