package it.beije.ananke.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import it.beije.ananke.model.Order;
import it.beije.ananke.model.OrderItem;
import it.beije.ananke.model.User;
import it.beije.ananke.model.Product;

public class JPAmanager {

	public void aggiungiUser(User user) {
		EntityManager em = CommerceEntityManager.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(user);
		et.commit();
		System.out.println("La voce è stata inserita correttamente.");
		em.close();
	}
	
	
	public boolean controlloEmail(String s) {
		List<User> list = new ArrayList<>();
		String jqlSelect = "SELECT u FROM User as u WHERE email = '" + s +"'";
		EntityManager em = CommerceEntityManager.getEntityManager();
		Query query = em.createQuery(jqlSelect);
		list = query.getResultList();
		em.close();
		if(list.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public User login(String email, String pswd) {
		List<User> list = new ArrayList<>();
		String jqlSelect = "SELECT u FROM User as u WHERE email = '" + email +"'";
		EntityManager em = CommerceEntityManager.getEntityManager();
		Query query = em.createQuery(jqlSelect);
		list = query.getResultList();
		if(list.size() == 0) {
			return null;
		}else {
			return list.get(0);
		}	
	}
	
	
	public List<Product> letturaProdotti(){
		List<Product> list = new ArrayList<>();
		String jqlSelect = "SELECT p FROM Product as p";
		EntityManager em = CommerceEntityManager.getEntityManager();
		Query query = em.createQuery(jqlSelect);
		list = query.getResultList();
		return list;
	}
	
	
	public Order creaOrdine() {
		Order order = new Order();
		return order;
	}
}
