package it.beije.ananke.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class JPAManager {
	
	public void returnList(){
	
		
	}
	public static boolean  addUser(String email, String nome, String Cognome,String password){
	
		if(!existsUser(email)) {
	EntityManager entityManager = JPASession.getEntityManager();
	EntityTransaction entityTransaction =entityManager.getTransaction();
		entityTransaction.begin();
		Users z= new Users();
		z.setEmail(email);
		z.setFirstNname(nome);
		z.setSecondName(Cognome);
		z.setPassword(password);
		entityManager.persist(z);
		entityTransaction.commit();
		entityManager.close();
		return true;
		}else
			return false;
}
	
	public static List<OrderItem> ritornoCarrello(int idUserp){

	EntityManager entityManager = JPASession.getEntityManager();
	String SQL="Select o from Order as o where id="+idUserp+" and  state='open'";
	System.out.println(SQL);
	Query queryOrder= entityManager.createQuery(SQL);
	Order ordine=null;
	if(queryOrder.getResultList().size()==0) {
	return null;
	}
	else {
		
		ArrayList<Order> ordini=(ArrayList<Order>) queryOrder.getResultList();
		ordine= ordini.get(0);
		SQL="Select o from OrderItem as o where orderID="+ordine.getId();
		queryOrder= entityManager.createQuery(SQL);
		return (List<OrderItem>) queryOrder.getResultList();

	}

		
		
	}
	
	public static boolean  addOrderItem(int idUserp, String idItem, String quantity){
		int idItemp=Integer.parseInt(idItem);
		int quantita=Integer.parseInt(quantity);
	EntityManager entityManager = JPASession.getEntityManager();
	EntityTransaction entityTransaction =entityManager.getTransaction();
	String SQL="Select o from Order as o where id="+idUserp+" and  state='open'";
	System.out.println(SQL);
	Query queryOrder= entityManager.createQuery(SQL);
	Order ordine=null;
	if(queryOrder.getResultList().size()==0) {
		entityTransaction.begin();
		ordine= new Order();
		ordine.setUserID(idUserp);
		ordine.setState("open");
		ordine.setAmount(0);
      entityManager.persist(ordine);
      entityTransaction.commit();

	}
	else {
		
		ArrayList<Order> ordini=(ArrayList<Order>) queryOrder.getResultList();
		ordine= ordini.get(0);
		
		SQL="Select o from OrderItem as o where orderID="+ordine.getId();
		queryOrder= entityManager.createQuery(SQL);
		ArrayList<OrderItem> carrelli=(ArrayList<OrderItem>) queryOrder.getResultList();
for(OrderItem c: carrelli)
	if(c.getProductID()==idItemp) {
		entityTransaction.begin();
		c.setQuantity(c.getQuantity()+quantita);
		Product prodotto=entityManager.find(Product.class, idItemp);
		if(prodotto==null)
			return false;
		c.setAmount(prodotto.getPrice()*c.getQuantity());
		entityManager.persist(c);
		ordine.setAmount(ordine.getAmount()+prodotto.getPrice()*c.getQuantity());

		entityTransaction.commit();
		return true;

	}
	}


		entityTransaction.begin();
		OrderItem z= new OrderItem();
		z.setOrderID(ordine.getId());
		z.setProductID(idItemp);
		z.setQuantity(quantita);
		Product prodotto=entityManager.find(Product.class, idItemp);
		if(prodotto==null)
			return false;
		z.setAmount(prodotto.getPrice()*quantita);
		entityManager.persist(z);
		entityTransaction.commit();
		entityManager.close();
		return true;
		
}
	
	public static boolean existsUser(String email) {
		EntityManager entityManager = JPASession.getEntityManager();
		String SQL="Select u from Users as u where email='"+email+"'";
		Query query=entityManager.createQuery(SQL);
		if(query!=null&&query.getResultList().size()!=0)
			return true;
		entityManager.close();
		return false;
	}

	public static Users returnUser(String email) {
		if(existsUser(email)) {
			EntityManager entityManager = JPASession.getEntityManager();
			String SQL="Select u from Users as u where email='"+email+"'";
			Query query=entityManager.createQuery(SQL);
			if(query!=null) {
			List<Users> utente=(ArrayList<Users>)query.getResultList();
			entityManager.close();
			return utente.get(0);
			}
			entityManager.close();
			return null;
		}
		return null;
	}
	public static ArrayList<Product> returnProducts() {
		
			EntityManager entityManager = JPASession.getEntityManager();
			String SQL="Select u from Product as u ";
			Query query=entityManager.createQuery(SQL);
			if(query!=null) {
			List<Product> prodotti=(ArrayList<Product>)query.getResultList();
			entityManager.close();
			return (ArrayList<Product>) prodotti;
			}
			entityManager.close();
			return null;
	
	}
	
	public static Product returnProduct(String id) {
		EntityManager entityManager = JPASession.getEntityManager();
		String SQL="Select u from Product as u where id="+id;
		Query query=entityManager.createQuery(SQL);
		if(query!=null) {
		List<Product> prodotti=(ArrayList<Product>)query.getResultList();
		entityManager.close();
		return prodotti.get(0);
		}
		entityManager.close();
		return null;

}

	public static Product returnProduct(int id) {
		EntityManager entityManager = JPASession.getEntityManager();
		
		String SQL="Select u from Product as u where id="+id;
		Query query=entityManager.createQuery(SQL);
		if(query!=null) {
		List<Product> prodotti=(ArrayList<Product>)query.getResultList();
		entityManager.close();
		return prodotti.get(0);
		}
		entityManager.close();
		return null;
}
	public static Order returnOrder(int id) {
		EntityManager entityManager = JPASession.getEntityManager();
		String SQL="Select u from Order as u where id="+id;
		Query query=entityManager.createQuery(SQL);
		if(query!=null) {
		List<Order> order=(ArrayList<Order>)query.getResultList();
		entityManager.close();
		return order.get(0);
		}
		entityManager.close();
		return null;

}
	
	
	
	public static ArrayList<Order> listaOrdiniUtente(int idUserp) {

		EntityManager entityManager = JPASession.getEntityManager();


		String SQL="Select o from Order as o where id="+idUserp;
		Query query=entityManager.createQuery(SQL);
		if(query!=null) {
			ArrayList<Order>  order=(ArrayList<Order>)query.getResultList();
			entityManager.close();
			return order;

	
		}
		entityManager.close();
		return null;

}
	
	
	public static void changeStateOrder(int id,String state) {

		EntityManager entityManager = JPASession.getEntityManager();
		EntityTransaction entityTransaction =entityManager.getTransaction();

		String SQL="Select u from Order as u where id="+id;
		Query query=entityManager.createQuery(SQL);
		if(query!=null) {
		List<Order> order=(ArrayList<Order>)query.getResultList();
		entityTransaction.begin();
		Order ordine= order.get(0);
ordine.setState(state);
	entityManager.persist(ordine);
	entityTransaction.commit();
		entityManager.close();
		}
}
	
	
	public static boolean passwordCorretta(String email,String password) {
		if(existsUser(email)) {
			EntityManager entityManager = JPASession.getEntityManager();
			String SQL="Select u from Users as u where email='"+email+"'";
			Query query=entityManager.createQuery(SQL);
			if(query!=null) {
			List<Users> utente=query.getResultList();
			if(utente.get(0).getPassword().equals(password))
				return true;
			else return false;
			
				
		}else
			return false;
		
		
}
		return false;
	}
}
