package it.beije.ananke.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository pr;
	
	
}
