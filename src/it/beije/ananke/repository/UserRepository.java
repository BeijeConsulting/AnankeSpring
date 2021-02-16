package it.beije.ananke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.model.Contatto;
import it.beije.ananke.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByEmail(String email);
	//SELECT * FROM rubrica WHERE name= ... AND surname = ...
	
	public List<User> findUsers();
	
}