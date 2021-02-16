package it.beije.ananke.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.model.Contatto;
import it.beije.ananke.model.User;


@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Integer>{

	public Contatto findByEmail(String email);
	
	//SELECT * FROM rubrica WHERE name= ... AND surname = ...
	public List<Contatto> findByNameAndSurname(String name, String surname);

	
}
