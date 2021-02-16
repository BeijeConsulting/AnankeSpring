package it.beije.ananke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.ananke.model.User;
import it.beije.ananke.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void save(User user) {
		userRepository.save(user);
		
	}
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
