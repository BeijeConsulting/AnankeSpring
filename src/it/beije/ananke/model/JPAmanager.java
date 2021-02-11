package it.beije.ananke.model;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

import it.beije.ananke.model.User;
import it.beije.ananke.model.RubricaEntityManager;

public class JPAmanager <T>{
	
	private EntityManager entityManager;
	
	public List<T> getList(String elemento) {
        entityManager = RubricaEntityManager.getEntityManager();
        String jpqlSelect = "SELECT c FROM " + elemento + " as c";
        Query query = entityManager.createQuery(jpqlSelect);
        @SuppressWarnings("unchecked")
        List<T> lista = query.getResultList();
        entityManager.close();
        System.out.println(lista);
        return lista; 
    }
	
	public Product getProduct(String nome) {
		entityManager = RubricaEntityManager.getEntityManager();
		String jpqlSelect = "SELECT * FROM  product"; // non è permesso l asterisco
		Query query = entityManager.createQuery(jpqlSelect);
		@SuppressWarnings("unchecked")
		List<Product> lista = query.getResultList();
		for(Product p : lista) {
			if(p.getName().equals(nome)) {
				return p;
			}
		
		}
		return null;
	}
	public void inOrder(Product p) {
		
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
			//		entityTransaction.rollback();
			entityManager.close();
		}
		}
		
	public boolean isRegister(String email) {
		
		return false;
	}
	
	public void doOrderItems(int id){
		entityManager = RubricaEntityManager.getEntityManager();
		Product p = entityManager.find(Product.class, id);
		String inserimento = "insert into order() values ()";
		}
	
	public ArrayList<User> stampaUser(){
		entityManager = RubricaEntityManager.getEntityManager();
		String jpqlSelect = "SELECT c FROM User as c";
		Query query = entityManager.createQuery(jpqlSelect);
		List<User> user = query.getResultList();
		entityManager.close();
		return (ArrayList<User>) user;
	}
	
	public User searchEmail(String email) {
		ArrayList<User> user = stampaUser();
		entityManager = RubricaEntityManager.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		User u1 = null;
		int indice=0;
		boolean b = false;
		for(int i=0;i<user.size();i++) {
			if(user.get(i).getEmail().equalsIgnoreCase(email)){	
				indice = user.get(i).getId();
				u1=entityManager.find(User.class, indice);
				}
			}
		entityManager.close();
		return u1;
		}
	
		
	

	public void update(String email,String nome, String cognome, String telefono) {
		ArrayList<User> user = stampaUser();
		entityManager = RubricaEntityManager.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		User u1;
		int indice=0;
		boolean b = false;
		for(int i=0;i<user.size();i++) {
			if(user.get(i).getEmail().equalsIgnoreCase(email)) {
				
				indice = user.get(i).getId();
				u1=entityManager.find(User.class, indice);	
				u1.setFirst_name(nome);
				u1.setSecond_name(cognome);
				u1.setPassword(telefono);
				if(u1.getEmail().trim().equals("")) {
					b=false;
					entityTransaction.rollback(); //se non voglio salvare la modifica	
				}
				else {
					b=true;
					entityManager.persist(u1);
					entityTransaction.commit(); //Se voglio applicare i cambiamenti
				}
			}
		}
	
		entityManager.close();
	}

	
	public String read() {
		//JPQL
		entityManager = RubricaEntityManager.getEntityManager();
		String jpqlSelect = "SELECT c FROM Contatto as c";
		Query query = entityManager.createQuery(jpqlSelect);
		List<Contatto> contatti = query.getResultList();
		StringBuilder sb = new StringBuilder("");
		for (Contatto contatto : contatti) {
//			System.out.println("id : " + contatto.getId());
//			System.out.println("name : " + contatto.getName());
//			System.out.println("surname : " + contatto.getSurname());
//			System.out.println("telephone : " + contatto.getTelephone());
//			System.out.println("email : " + contatto.getEmail());
			sb.append("id : " + contatto.getId() + " name : " + contatto.getName() + 
					" surname : " + contatto.getSurname() + "telephone : " + contatto.getTelephone() + 
					" email : " + contatto.getEmail()+ " \n");
		}
		
		String s = sb.substring(0);
		return s;
	}

	public void delete(String emaildel) {		
		ArrayList<User> user= stampaUser();
		entityManager = RubricaEntityManager.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		User u1;
		int indice =0;
		for(int i=0;i<user.size();i++) {
			if(user.get(i).getEmail().equalsIgnoreCase(emaildel)) {
				indice = user.get(i).getId();
				u1=entityManager.find(User.class, indice);
				entityManager.remove(u1);
				System.out.println("Contatto eliminato");
				entityTransaction.commit();
			}


			//		entityTransaction.rollback();
		}
		entityManager.close();
	}
		
	}


