package it.beije.ananke.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String email);
	
	public User save(User user);
	
	public Optional<User> findById(Integer id);
	
	public List<User> findAll();
}
