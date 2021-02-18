package it.beije.ananke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.model.Product;
import it.beije.ananke.model.User;
import it.beije.ananke.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public void save(Product product) {
		productRepository.save(product);
	}

	public void remove(String productName) {
		productRepository.deleteByProductName(productName);
		
	}
	//public Product getProduct(Integer id) {
		//Optional<Product> optional = productRepository.findById(id);
		
	//}
	
	 
}
