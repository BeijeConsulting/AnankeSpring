package it.beije.ananke.ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
