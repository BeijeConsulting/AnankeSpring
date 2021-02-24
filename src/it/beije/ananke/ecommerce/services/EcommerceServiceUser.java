package it.beije.ananke.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.ecommerce.EcommerceException;
import it.beije.ananke.ecommerce.beans.User;
import it.beije.ananke.ecommerce.repositories.EcommerceRepositoryUser;

@Service
public class EcommerceServiceUser extends EcommerceService{
	
	@Autowired
	private EcommerceRepositoryUser repoUser;
	
	public User save(User user) throws EcommerceException {
		
		User userDB = repoUser.findByEmail(user.getEmail());
		
		if(userDB == null) {
			
			//non esiste già il contatto, allora posso salvarlo
			repoUser.save(user);
			
		}
		else {
			throw new EcommerceException("Sei già stato registrato");			
		}
		
		return user;
		
	}
	
	public User findByEmail(String email) {
		
		User user = repoUser.findByEmail(email);
		
		return user;
		
	}

	public User findById(Integer userId) {
		
		User user = repoUser.findById(userId).get();
		
		return user;
		
	}
}
