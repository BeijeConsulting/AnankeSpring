package it.beije.ananke.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.ecommerce.model.Product;
import it.beije.ananke.ecommerce.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product findById(int id)
	{
		Optional<Product> prod = productRepository.findById(id);
		
		return prod.get();
	}
	
	public List<Product> findAll()
	{
		return productRepository.findAll();
	}
	
	public List<Product> findItemsByOrderId(Integer ordId)
	{
		return productRepository.findItemsByOrderId(ordId);
	}
}