package it.beije.ananke.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.entity.Product;
import it.beije.ananke.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product findById(int id)
	{
		Optional<Product> prod = productRepository.findById(id);
		
		return prod.get();
	}
}
