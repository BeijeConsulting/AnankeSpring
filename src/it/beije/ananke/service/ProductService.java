package it.beije.ananke.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.entity.Product;
import it.beije.ananke.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public void save(String nome, String descrizione, double prezzo) {
		
		Product product = new Product(nome, descrizione, prezzo);
		
		System.out.println("prodotto: " + product);
		
		productRepository.save(product);
		
	}
	
	public List<Product> findAll() {
		
		List<Product>prodotti = productRepository.findAll();
		
		return prodotti;
		
	}
	
	
	public boolean removeById(int id) {
		
		boolean rimosso = false;
		
		try {
			Optional<Product> product = productRepository.findById(id);
			
			if(product.isPresent()) {
				
				Product tempProduct = product.get();
				productRepository.delete(tempProduct);
				rimosso = true;
				
			}else rimosso = false;

		}
		catch(Exception e) {
			rimosso = false;
		}
		
		return rimosso;
		
	}
	

}
