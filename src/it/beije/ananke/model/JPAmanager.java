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


	public void inOrder(int id) {
		entityManager = RubricaEntityManager.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Product pr = entityManager.find(Product.class, id);
		Order or = new Order();

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
		ArrayList<User> utenti = (ArrayList<User>) getList("User");
		boolean b = false;
		for (User str : utenti) {
			if(str.getEmail().equals(email)) {
				b=true;
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


