package it.beije.ananke.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.ananke.model.Contatto;
import it.beije.ananke.model.JPAmanager;
import it.beije.ananke.model.Product;
import it.beije.ananke.model.User;
import it.beije.ananke.repository.ContattoRepository;
import it.beije.ananke.repository.ProductRepository;
import it.beije.ananke.repository.UserRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product findById(Integer id) {
		Optional<Product> p = productRepository.findById(id);
		return p.get();
	}
	
	public void buyProduct(Integer id, int quantita) {
	//il metodo potrbbe essere void
		Optional<Product> p = productRepository.findById(id);
		System.out.println(id + " " + quantita);
		int tot =  (int) (p.get().getPrice() * quantita);
		System.out.println(tot);
		//inseristoil totale nell orderitems ecc
		
	}
	
}