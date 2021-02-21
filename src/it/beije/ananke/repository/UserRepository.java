package it.beije.ananke.repository;

import org.springframework.stereotype.Repository;

import antlr.collections.List;
import it.beije.ananke.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
	
	public User findByEmail(String email);
	public User findByEmailAndPassword(String email, String password);
	
}
