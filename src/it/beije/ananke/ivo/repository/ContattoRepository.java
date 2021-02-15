package it.beije.ananke.ivo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.model.Contatto;

@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Integer>{

	public Contatto findByEmail(String email);
	
	//SELECT * FROM rubrica WHERE name= ... AND surname = ...
	public List<Contatto> findByNameAndSurname(String name, String surname);
	
}
