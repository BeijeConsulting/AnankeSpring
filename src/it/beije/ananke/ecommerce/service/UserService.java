package it.beije.ananke.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User findByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}
	
	public User save(User utente)
	{
		return userRepository.save(utente);
	}
	
	public List<User> findAll()
	{
		return userRepository.findAll();
	}
	
	public boolean deleteById(int id)
	{
		userRepository.deleteById(id);
		
		if(userRepository.existsById(id))
		{
			return false;
		}
			return true;
	}
}