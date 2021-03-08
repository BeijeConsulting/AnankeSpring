package it.beije.ananke.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.ecommerce.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByEmailAndPassword(String email, String password);
	
	public User findByEmail(String email);
}
