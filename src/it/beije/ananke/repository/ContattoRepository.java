package it.beije.ananke.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.model.User;

public interface ContattoRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String email);
	
}
