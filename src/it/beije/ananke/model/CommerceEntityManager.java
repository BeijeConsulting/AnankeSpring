package it.beije.ananke.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CommerceEntityManager {
	
	private CommerceEntityManager() {}
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
			System.out.print("CIAO");
			entityManagerFactory = Persistence.createEntityManagerFactory("rubrica");
			System.out.print("WIIII");
		}
		
		return entityManagerFactory.createEntityManager();
	}

}
