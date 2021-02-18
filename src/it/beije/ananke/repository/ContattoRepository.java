//
//
//package it.beije.ananke.repository;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import it.beije.ananke.model.Contatto;
//
//
//@Repository
//public interface ContattoRepository extends JpaRepository<Contatto, Integer>{
//
//	public Contatto findByEmail(String email);
//	
//	//SELECT * FROM rubrica WHERE name= ... AND surname = ...
//	public List<Contatto> findByNameAndSurname(String name, String surname);
//	
//	
//	//SELECT * FROM rubrica WHERE surname LIKE '...%'
//	@Query(nativeQuery = true, value ="SELECT * FROM contatti WHERE surname LIKE :letters%")
//	public List<Contatto> searchByFirstLettersOfSurname(@Param("letters") String letters);
//	
//}

