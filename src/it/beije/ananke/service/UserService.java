package it.beije.ananke.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.entity.User;
import it.beije.ananke.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	

	public void save(String email, String nome, String cognome, String password) {
		
		User user = new User(email, nome, cognome, password);
		
		userRepository.save(user);
		
	}


	public boolean verificaUtente(String nome, String password) {
		
		boolean valid = false;
		
		User user = userRepository.findByEmailAndPassword(nome, password);
		
		System.out.println("User : " + user);
	
		if(!(user == null)) {
			System.out.println("Email e password valide");
			valid = true;
		}else if (user == null) {
			System.out.println("Email e/o password errate");
			valid = false;
		}
		
		return valid;
		
	}
	
}
