package it.beije.ananke.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.model.Product;
import it.beije.ananke.model.User;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	public User findByProductName(String productName);

	public void deleteByProductName(String productName);
	
	
	
}
