package it.beije.ananke.ecommerce.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.ananke.ecommerce.beans.OrderItem;
import it.beije.ananke.ecommerce.beans.Product;

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
