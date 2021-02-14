package it.beije.ananke.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;


public class JPAmanager<T> {

	private EntityManager entityManager;

	public List<T> getList(String elemento) {
		entityManager = RubricaEntityManager.getEntityManager();
		String jpqlSelect = "SELECT c FROM " + elemento + " as c";
		Query query = entityManager.createQuery(jpqlSelect);
		@SuppressWarnings("unchecked")
		List<T> lista = query.getResultList();
		entityManager.close();
		return lista; 
	}


	public void inOrder(int Productid, int orderID, int q) {
		entityManager = RubricaEntityManager.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		ArrayList<Order_items> listItems = (ArrayList<Order_items>)getList("order_items");
		ArrayList<Product> listaProduct = (ArrayList<Product>)getList("Product");
		Product p = null;
		for(Product pr : listaProduct) {
			if(pr.getId()== Productid) {
				p = pr;
			}
		}
		boolean b = false;

		Order_items or = new Order_items();
		for(Order_items ord : listItems) {
			if(ord.getProduct_id() == Productid && orderID == ord.getOrder_id())
				b = true;
			or = ord;
		}

		if(b) {
			int quantita = or.getQuantity() + q;
			or.setId(orderID);
			or.setAmount(quantita);

		}else {
			or.setQuantity(q);
			or.setOrder_id(orderID);
			or.setProduct_id(Productid);
		}
		entityManager.persist(or);
		entityTransaction.commit();
		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public boolean isRegister(String email, String psw){
		entityManager = RubricaEntityManager.getEntityManager();
		ArrayList<User> elenco = (ArrayList<User>) getList("User");
		for(User s : elenco) {
			if(s.getEmail().equals(email) && s.getPassword().equals(psw)) {
				return true;
			}
		}
		return false;
	}

	public void inserimento(String email,String password,String name, String surname) {
		@SuppressWarnings("unchecked")
		ArrayList<User> utenti = (ArrayList<User>) getList("User");
		boolean b = false;
		for (User str : utenti) {
			if(str.getEmail().equals(email)) {
				b=true;
				break;
			}
		}
		if (b == false) {
			entityManager = RubricaEntityManager.getEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			User newUser = new User();
			newUser.setFirst_name(name);
			newUser.setSecond_name(surname);
			newUser.setEmail(email);
			newUser.setPassword(password);
			entityManager.persist(newUser);
			System.out.println("l' id del nuovo contatto è: " + newUser.getId());
			entityTransaction.commit();
			entityManager.close();
		}
	}

	public void doOrderItems(int id){

	}

}


