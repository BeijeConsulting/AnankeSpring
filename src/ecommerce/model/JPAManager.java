package ecommerce.model;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;


import ecommerce.entity.*;

public class JPAManager {

	// USER JPA MANAGER
	public static List<User> getAllUsers() {
		EntityManager em = EntityManagerGenerator.getEntityManager();
		String jpqlSelect = "SELECT u FROM User as u";
		Query query = em.createQuery(jpqlSelect);
		List<User> users = query.getResultList();
		em.close();
		return users;
	}
	public static boolean isUser(String email, String password) {
		List<User> users = getAllUsers();
		for(User u : users) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isEmailPresent(String email) {
		List<User> users = getAllUsers();
		for(User u : users) {
			if(u.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	public static User getUser(String email, String password) {
		List<User> users = getAllUsers();
		for(User u : users) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}
	
	
	public static void insertUser(User u) {
		EntityManager em = EntityManagerGenerator.getEntityManager();
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		em.persist(u);
		t.commit();
		em.close();
	}
	
	public static boolean deleteUsers(User u) {
		EntityManager em = EntityManagerGenerator.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.remove(em.find(User.class, u.getId()));
		t.commit();
		return true;
		
	}
	
	
	
	//PRODUCT JPA MANAGER
	public static List<Product> getAllProducts() {
		EntityManager em = EntityManagerGenerator.getEntityManager();
		String jpqlSelect = "SELECT p FROM Product as p";
		Query query = em.createQuery(jpqlSelect);
		List<Product> products = query.getResultList();
		em.close();
		return products;
	}
	
	public static Product getProduct(int id) {
		List<Product> products = getAllProducts();
		for(Product p : products) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	public static void insertProduct(Product p) {
		EntityManager em = EntityManagerGenerator.getEntityManager();
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		em.persist(p);
		t.commit();
		em.close();
	}
	
	public static boolean deleteContacts(Product p) {
		EntityManager em = EntityManagerGenerator.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.remove(em.find(Product.class, p.getId()));
		t.commit();
		return true;
		
	}
	
	// ORDER JPAMANAGER
	public static List<Order> getAllOrders() {
		EntityManager em = EntityManagerGenerator.getEntityManager();
		String jpqlSelect = "SELECT o FROM Order as o";
		Query query = em.createQuery(jpqlSelect);
		List<Order> orders = query.getResultList();
		em.close();
		return orders;
	}
	
	public static void insertOrder(Order o) {
		EntityManager em = EntityManagerGenerator.getEntityManager();
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		em.persist(o);
		t.commit();
		em.close();
	}
	
	public static boolean deleteOrders(Order o) {
		EntityManager em = EntityManagerGenerator.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.remove(em.find(Order.class, o.getId()));
		t.commit();
		return true;
		
	}
	
	// ORDER_ITEM JPA MANAGER
	
	public static List<Order_Item> getAllOrder_Items() {
		EntityManager em = EntityManagerGenerator.getEntityManager();
		String jpqlSelect = "SELECT oi FROM Order_Item as oi";
		Query query = em.createQuery(jpqlSelect);
		List<Order_Item> order_items = query.getResultList();
		em.close();
		return order_items;
	}
	
	public static void insertOrder_Item(Order_Item oi) {
		EntityManager em = EntityManagerGenerator.getEntityManager();
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		em.persist(oi);
		t.commit();
		em.close();
	}
	
	public static boolean deleteOrder_Items(Order_Item oi) {
		EntityManager em = EntityManagerGenerator.getEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.remove(em.find(Order_Item.class, oi.getId()));
		t.commit();
		return true;
		
	}
	
	
	
}
