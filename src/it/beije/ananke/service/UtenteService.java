package it.beije.ananke.service;

import java.util.List;

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
public class UtenteService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;


	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findByEmailAndPassword(String email, String password) {
		User u = userRepository.findByEmail(email);
		if(u!=null & u.getPassword().equals(password))
			return u;
		else 
			return null;
	}

	public List<Product> searchProducts(){
		return productRepository.findAll();
	}

	public User insertUser(String email, String password, String first_name, String second_name) {
		User u = new User();
		if(userRepository.findByEmail(email)==null) {
			u.setEmail(email);
			u.setFirst_name(first_name);
			u.setSecond_name(second_name);
			u.setPassword(password);
			userRepository.save(u);
			return u;
		}
		else {
			return null;
		}
	}
	
	public void updateUser(String email, String password, String first_name, String second_name, HttpSession session) {
		User u = (User) session.getAttribute("Utente");
		System.out.println(u.toString());
			u.setEmail(u.getEmail());
			u.setFirst_name(first_name);
			u.setSecond_name(second_name);
			u.setPassword(password);
			System.out.println(u.toString());
			userRepository.save(u);
			return;
	}
}