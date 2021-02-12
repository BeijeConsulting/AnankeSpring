package it.beje.ananke.ecommerce;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class JPAPoducts {
	
	public static List<Product> getProducts() {
		
		EntityManager entityManager = JPAEntityManager.getEntityManager();
		String jpqlSelect = "SELECT p FROM Product as p";
		Query query = entityManager.createQuery(jpqlSelect);
		List<Product> products = query.getResultList();
		
		return products;
		
	}
	
	public static boolean confirmOrderItem(List<OrderItem> items) {
		
		EntityManager entityManager = JPAEntityManager.getEntityManager();
		
		//apro transazione
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		for (OrderItem orderItem : items) {
			entityManager.persist(orderItem);
			entityTransaction.commit();
		}
		
		entityManager.close();
		
		return true;
	}

}
