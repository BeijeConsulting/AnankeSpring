package it.beije.ananke.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.repositories.UserRepository;

@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/user/{id}") // /api/contatto/{id}
	public User getContatto(@PathVariable Integer id) {
		System.out.println("api getContatto id : " + id);
		
		User u = userRepository.findById(id).get();
		System.out.println(u);
		
		return u;		
	}

}
