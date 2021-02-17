package it.beije.ananke.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public List<Product> findAll();
	
	public Optional<Product> findById(Integer productId);
}
