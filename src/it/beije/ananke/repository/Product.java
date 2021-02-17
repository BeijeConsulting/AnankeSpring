package it.beije.ananke.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.model.*;

public interface Product extends JpaRepository<Product, Integer>  {

}
