package it.beije.ananke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
