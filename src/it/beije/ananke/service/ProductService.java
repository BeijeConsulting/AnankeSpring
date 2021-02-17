package it.beije.ananke.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.model.Product;
import it.beije.ananke.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public Product returnProduct(Integer id) {
	Optional<Product> c=	 productRepository.findById(id);
		return c.get();
	}
	
}
