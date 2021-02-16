package it.beije.ananke.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByEmail(String email);

	public User findByEmailAndPassword(String email, String password);
	
}
