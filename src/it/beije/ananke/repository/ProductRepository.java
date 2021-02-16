package it.beije.ananke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public List<Product> findAll();
}
