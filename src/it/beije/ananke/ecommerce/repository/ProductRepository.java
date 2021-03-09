package it.beije.ananke.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.ecommerce.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public List<Product> findAll();
}
