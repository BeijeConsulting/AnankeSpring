package it.beije.ananke.ecommerce;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;

//public class JPAmanager {
//	EntityManager entityManager = EcommerceEntityManager.getEntityManager();
//	
//	public void addUser(User user) {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		entityManager.persist(user);		
//		entityTransaction.commit();		
//	}
//	
//	public void addOrder(Order order) {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		entityManager.persist(order);		
//		entityTransaction.commit();		
//	}
//	
//	public List<User> findAllUsers(){
//		String ricerca = "SELECT u FROM User as u";
//		Query query = entityManager.createQuery(ricerca);
//		return query.getResultList();	
//	}
//	
//	public List<Product> findAllProducts(){
//		String ricerca = "SELECT p FROM Product as p";
//		Query query = entityManager.createQuery(ricerca);
//		return query.getResultList();	
//	}
//	
//	public void deleteUser(int id) {
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		entityTransaction.begin();
//		entityManager.find(User.class, id);
//		entityManager.remove(entityManager.find(User.class, id));
//		entityTransaction.commit();
//	}
//	
//	public User findUser(int id) {
//		return entityManager.find(User.class, id);		 
//	}
//	
//	public int findUser(String email) {
//		String ricerca = "SELECT id FROM User WHERE email='" + email + "'";
//		Query query = entityManager.createNativeQuery(ricerca);
//		return Integer.parseInt(query.getSingleResult().toString());		 
//	}
//	
//	public Product findProduct(int id) {
//		return entityManager.find(Product.class, id);		 
//	}
//	
//	public Order findOrder(int id) {
//		return entityManager.find(Order.class, id);		 
//	}
//	
////	public addOrder(){
////		
////	}
//	
//	public boolean authentication(String email, String password) {
//		List<User> users = findAllUsers();
//		for(User user : users) {
//			if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
//				return true;
//			}			
//		}
//		return false;
//	}
//	
//
////	public void modificaContattoJPA(int id, Contatto contattoModificato) {
////		EntityTransaction entityTransaction = entityManager.getTransaction();
////		entityTransaction.begin();
////		
////		Contatto contatto = new Contatto();
////		contatto = entityManager.find(Contatto.class, id);
////		contatto.setNome(contattoModificato.getNome());
////		contatto.setCognome(contattoModificato.getCognome());
////		contatto.setEmail(contattoModificato.getEmail());
////		contatto.setTelefono(contattoModificato.getTelefono());
////		entityManager.persist(contatto);
////		entityTransaction.commit();
////	}
//	
////	public void eliminaUser(List<Contatto> contatti) {
////		EntityTransaction entityTransaction = entityManager.getTransaction();
////		entityTransaction.begin();
////		
////		for(Contatto contatto : contatti) {
////			entityManager.remove(contatto);
////		}
////		entityTransaction.commit();
////		System.out.println("Contatti eliminati");
////	}	
//}
