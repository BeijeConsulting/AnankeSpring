package it.beje.ananke.ecommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
