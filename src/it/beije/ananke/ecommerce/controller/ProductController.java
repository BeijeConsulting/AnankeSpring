package it.beije.ananke.ecommerce.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.ecommerce.model.Product;
import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.model.dao.JpaDao;

@Controller
public class ProductController {

	@RequestMapping(value = "/showProducts", method = RequestMethod.GET)
	public String showProducts(Model model) {
		
		JpaDao dao = new JpaDao();
		List<Product> products = dao.selectAll(Product.class, "name");
		
		model.addAttribute("products",products);
		
		System.out.println("in show products");
		return "products";
	}
	
}
