package it.beije.ananke.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.ananke.ecommerce.beans.Product;
import it.beije.ananke.ecommerce.beans.User;
import it.beije.ananke.ecommerce.repositories.EcommerceRepositoryProduct;

@Service
public class EcommerceServiceProduct {

	@Autowired
	private EcommerceRepositoryProduct repoProduct;
	
	public Product findById(Integer id) {
		
		Product product = repoProduct.findById(id).get();
		
		return product;
		
	}
	
	public List<Product> findAll(){
		
		List<Product> products = repoProduct.findAll();
		
		return products;
		
	}
	
	public List<Product> findTopProducts(){
		
		List<Product> products = repoProduct.findAll();
		
		return products;
	}
	
}
