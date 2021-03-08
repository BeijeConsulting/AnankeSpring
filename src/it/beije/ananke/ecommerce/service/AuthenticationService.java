package it.beije.ananke.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.ecommerce.User;
import it.beije.ananke.ecommerce.repository.UserRepository;

@Service
public class AuthenticationService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User findById(Integer id) {
		return userRepository.findById(id).get();
	}
	
	public boolean deleteById(Integer id) {
		userRepository.deleteById(id);
		return !userRepository.existsById(id);
	}
	
	public boolean alreadyThere(String email) {
		User user = userRepository.findByEmail(email);
		if(user == null) {
			return false;
		}else {
			return true;
		}
	}
}
