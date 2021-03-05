package it.beije.ananke.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.ecommerce.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	//SELECT * FROM user
	public List<User> findAll();
	
	//SELECT * FROM user WHERE email='email'
	public User findByEmail(String email);
	
}