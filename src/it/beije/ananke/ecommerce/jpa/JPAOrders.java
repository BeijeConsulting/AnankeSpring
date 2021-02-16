package it.beije.ananke.ecommerce.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import it.beije.ananke.ecommerce.beans.Orders;

public class JPAOrders {
	
	//un ordine è collegato a un utente
	//la tabella ordini la tocco solamente quando un utente decide di 
	//acquistare definitivamente dei prodotti e quindi aggiungo l'ordine effettuato al db
	
	public static boolean confirmOrder(Orders order) {
		
		EntityManager entityManager = JPAEntityManager.getEntityManager();
		
		//apro transazione
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(order);
		entityTransaction.commit();
		entityManager.close();		
		
		return true;
		
	}

}
