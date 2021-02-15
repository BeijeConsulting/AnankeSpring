package it.beje.ananke.ecommerce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class JPAUsers {

	//magari fare due jpa manager
	//UNA sicuro per gestire sol gli user 
	//	select di uno user
	//	insert di uno user
	
	//UNA per i prodotti
	
	//una per gli ordini
	
	public static boolean userIsRegisted(User user) {
		
		EntityManager entityManager = JPAEntityManager.getEntityManager();
		String jpqlSelect = "SELECT u FROM User as u WHERE u.email := email";
		Query query = entityManager.createQuery(jpqlSelect);
		query.setParameter("email", user.getEmail());
		List<User> users = query.getResultList();
		
		User userDB = users.get(0);
		if(userDB != null)
			return true;
		else
			return false;
		
	}
	
	public static boolean registerUser(User user) {
		
		EntityManager entityManager = JPAEntityManager.getEntityManager();
		
		//apro transazione
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		//ho già fatto nel controller il controllo dei campi email e pw NOT NULL
		entityManager.persist(user);
			
		if(!userIsRegisted(user)) {
			entityTransaction.commit();
			entityManager.close();
		}
		else {
			entityTransaction.rollback();
			entityManager.close();
			return false;
		}
			
		return true;
		
	}
	
	public static boolean logInUser(User user) {
		
		if(userIsRegisted(user)) {
			
			EntityManager entityManager = JPAEntityManager.getEntityManager();
			String jpqlSelect = "SELECT u FROM User as u WHERE u.email := email";
			Query query = entityManager.createQuery(jpqlSelect);
			query.setParameter("email", user.getEmail());
			List<User> users = query.getResultList();
			
			User userDB = users.get(0);
			
			if(user.getPassword().equals(userDB.getPassword()))
				return true;
			
			
		}
		
		return false;
		
	}

	
}
