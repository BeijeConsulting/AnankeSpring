package it.beije.ananke.ecommerce.restcontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.repositories.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/user/{id}") // /api/contatto/{id}
	public User getContatto(@PathVariable Integer id) {
		System.out.println("api getUser id : " + id);
		
		User u = userRepository.findById(id).get();
		System.out.println(u);
		
		return u;		
	}
	
	@GetMapping("/session") // /api/contatto/{id}
	public User getSession(HttpSession session) {
		System.out.println(session);
		return (User) session.getAttribute("user");		
	}
	
	
	@PostMapping("/login")
	public User login(@RequestBody User requestedUser, HttpSession session) {
		System.out.println("sto chiamando login");
		System.out.println("request user:" + requestedUser.getEmail());
		User user = userRepository.findByEmail(requestedUser.getEmail());
		if (user != null) {
			if (user.getPassword().equals(requestedUser.getPassword())) {
				System.out.println("user from database: " + user.getEmail() + user.getId());
				session.setAttribute("user", user);
				return user;
			}
		}
		
		return null;
	}

}
