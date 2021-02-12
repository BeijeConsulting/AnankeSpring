package it.beije.ananke.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.ananke.entity.User;


public class JPAManager {

		
	EntityManager entityManager = EcommerceEntityManager.getEntityManager();
	
	public void chiudiConnessioneDb() {
		
		entityManager.close();
		
	}
	
	public void inserisciUtenteDb(String nome, String cognome, String password, String email) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		User user = new User(password, nome, cognome, email);
		
		entityManager.persist(user);
		
		entityTransaction.commit();
		
	}
	
	public boolean verificaUtenteDb(String username, String password) {
		
		boolean valid = false;
		
		String jpqlSelect = "SELECT u FROM User as u WHERE u.email = '" + username + "' and u.password = '"+ password +"'";
		
		Query query = entityManager.createQuery(jpqlSelect);
		
		List<Contatto> users = query.getResultList();
		
		if(!(users.isEmpty())) {
			System.out.println("Email e password valide");
			valid = true;
		}else if (users.isEmpty()) {
			System.out.println("Email e/o password errate");
			valid = false;
		}
		
		return valid;
	}

}