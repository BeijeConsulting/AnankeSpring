package it.beije.ananke.ecommerce.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAEntityManager {
	
	private JPAEntityManager() {}
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
			entityManagerFactory = Persistence.createEntityManagerFactory("Rubrica");
		}
		
		return entityManagerFactory.createEntityManager();
	}
}
