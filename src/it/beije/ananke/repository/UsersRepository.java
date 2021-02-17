package it.beije.ananke.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.model.Contatto;
import it.beije.ananke.model.Users;


public interface UsersRepository extends JpaRepository<Users, Integer>  {
	public Users findByEmail(String email);
	
	public Users findByEmailAndPassword(String email,String password);

}
