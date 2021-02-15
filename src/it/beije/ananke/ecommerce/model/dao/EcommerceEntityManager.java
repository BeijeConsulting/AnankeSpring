package it.beije.ananke.ecommerce.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EcommerceEntityManager{
	
	private EcommerceEntityManager() {}
	
	private static EntityManagerFactory entityManagerFactory;
	
	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null || !entityManagerFactory.isOpen()) {
			entityManagerFactory = Persistence.createEntityManagerFactory("AnankeSpring");
		}
		
		return entityManagerFactory.createEntityManager();
	}

}
