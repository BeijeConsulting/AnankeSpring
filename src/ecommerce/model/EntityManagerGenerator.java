package ecommerce.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerGenerator {
	private static EntityManagerFactory entityManagerFactory;
	private EntityManagerGenerator() {
		
	}
	
	public static EntityManager getEntityManager() {
		if(entityManagerFactory == null || !entityManagerFactory.isOpen()) 
			entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce");
		return entityManagerFactory.createEntityManager();
	}
}
