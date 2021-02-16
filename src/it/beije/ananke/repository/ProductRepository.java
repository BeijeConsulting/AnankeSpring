package it.beije.ananke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.model.Product;
import it.beije.ananke.model.User;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer> {
	
	java.util.List<Product> findProduct();
	
}
