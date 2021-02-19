package it.beije.ananke.ecommerce.controller.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.repositories.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/user/{id}") // /api/contatto/{id}
	public User getUser(@PathVariable Integer id) {
		System.out.println("api getUser id : " + id);
		
		User u = userRepository.findById(id).get();
		System.out.println(u);
		
		return u;		
	}

////	@RequestMapping(value = "/contatto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/user")
	public User insertUser(@RequestBody User user) {
		System.out.println("api insertUser user : " + user);

		userRepository.save(user);

		return user;
	}

	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable Integer id, @RequestBody User user) {
		System.out.println("api updateUser id : " + id);
		System.out.println("api updateUser user.id : " + user.getId());

		if (id.compareTo(user.getId()) == 0) {
			System.out.println("ID coerenti");

			Optional<User> optC = userRepository.findById(id);
			System.out.println("optC isPresent ? " + optC.isPresent());
			if (optC.isPresent()) {
				User u = optC.get();

				if (user.getFirstName() != null) u.setFirstName(user.getFirstName());
				if (user.getSecondName() != null) u.setSecondName(user.getSecondName());
				if (user.getEmail() != null) u.setEmail(user.getEmail());

				return userRepository.save(u);

			} else throw new IllegalArgumentException("ID user non trovato");

		} else throw new IllegalArgumentException("IDs non coerenti");
	}

}
