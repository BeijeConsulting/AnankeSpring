package it.beije.ananke.ecommerce.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.ecommerce.Product;
import it.beije.ananke.ecommerce.User;
import it.beije.ananke.ecommerce.service.AuthenticationService;

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class AuthenticationRestController {

	@Autowired
	private AuthenticationService authService; 
	
	@PostMapping(value = "/register")
	public User register(@RequestBody User user) {
		if(authService.alreadyThere(user.getEmail())) {
			return new User();
		}else {
			return authService.save(user);
		}
	}
	
	@DeleteMapping(value ="/delete")
	public boolean delete(@RequestParam int id) {
		return authService.deleteById(id);		
	}
	
	@PostMapping(value = "/login")
	public User login(@RequestBody User user) {
		user = authService.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if(user != null) {			
			return user;
		}
		return new User();
	}
}
