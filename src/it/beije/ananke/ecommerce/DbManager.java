package it.beije.ananke.ecommerce;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.beije.ananke.ecommerce.JPAEntityManager;

public final class DbManager {
	
		public static int NUM_CARRELLI;
		static {NUM_CARRELLI = 0;}
	
		@SuppressWarnings("unchecked")
		public static List<Prodotto> getProdotti(){
		
			List<Prodotto> list = new ArrayList<>();
			EntityManager entityManager = JPAEntityManager.getEntityManager();
			String jpqlSelect = "SELECT p FROM Prodotto as p";
					  
			
			Query query = entityManager.createQuery(jpqlSelect);
			list = query.getResultList();
		
			return list;
		
	}
		@SuppressWarnings("unchecked")
		public static List<Carrello> getCarrello(int idUtente) {
			
			List<Carrello> list = new ArrayList<>();
			EntityManager entityManager = JPAEntityManager.getEntityManager();
			String jpqlSelect = "SELECT c FROM Carrello as c WHERE idUtente ='" + idUtente + "'";
					  
			Query query = entityManager.createQuery(jpqlSelect);
			list = query.getResultList();
		
			return list;
			
		}
		
		@SuppressWarnings("unchecked")
		public static Prodotto getProdotto(int idProdotto) {
			
			List<Prodotto> list = new ArrayList<>();
			EntityManager entityManager = JPAEntityManager.getEntityManager();
			String jpqlSelect = "SELECT p FROM Prodotto as p WHERE id =" + idProdotto;
					  
			
			Query query = entityManager.createQuery(jpqlSelect);
			list = query.getResultList();
			Prodotto p = list.get(0);
		
			return p;
			
		}
	

}