package it.beije.ananke.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import it.beije.ananke.ecommerce.beans.Product;
import it.beije.ananke.ecommerce.beans.User;
import it.beije.ananke.ecommerce.repositories.EcommerceRepositoryProduct;

public class EcommerceService {

	@Autowired
	private EcommerceRepositoryProduct repoProduct;
	
	public Model setAllProductToModel(Model model){
		
		List<Product> products = repoProduct.findAll();
		
		model.addAttribute("products", products);
		
		return model;
		
	}
	
}
