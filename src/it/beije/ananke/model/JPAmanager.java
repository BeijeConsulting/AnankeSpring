package it.beije.ananke.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;


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

	public boolean isExsistOrder(int utenteID) {
		ArrayList<Order> listaordini = new ArrayList<>();
		for(Order or: listaordini) {
			if(or.getUser_id() == utenteID) {
				return true;
			}
		}
		return false;
	}
	
	public int getIDorder(int userID) {
		ArrayList<Order> listaordini = new ArrayList<>();
		for(Order or: listaordini) {
			if(or.getUser_id() == userID)
				return or.getId();
		}
        return -1;
	}
	
	public void inOrder(int userID, int productID, int q) {
		entityManager = RubricaEntityManager.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Order_items or = new Order_items();
		if(isExsistOrder(userID)) {
			int id = getIDorder(userID);
			or.setOrder_id(id);
			or.setProduct_id(productID);
			or.setQuantity(q);
			entityManager.persist(or);
			entityTransaction.commit();
		}else {
			Order ord = new Order();
			ord.setUser_id(userID);
			ord.setState("attivo");
			entityManager.persist(ord);
			entityTransaction.commit();
			int id = getIDorder(userID);
			or.setOrder_id(id);
			or.setProduct_id(productID);
			or.setQuantity(q);
			entityManager.persist(or);
			entityTransaction.commit();
		}
		
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


