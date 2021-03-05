package it.beije.ananke.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.ananke.model.User;
import it.beije.ananke.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
/*
	@Autowired
	private UserRepository ur;
	
	public User findByEmail(String email) {
		return ur.findByEmail(email);
	}
	
	public User signUp(String email, String password, String name_param, String surname_param) {
		if(findByEmail(email) != null) {
			return null;
		}else {
			User user = new User();
			user.setEmail(email);
			user.setFirstName(name_param);
			user.setSecondName(surname_param);
			user.setPasword(password);
			ur.save(user);
			return user;
		}
	}
	*/
}
