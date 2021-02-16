package it.beije.ananke.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import it.beije.ananke.entity.Order;
import it.beije.ananke.entity.OrderItem;
import it.beije.ananke.entity.Product;
import it.beije.ananke.entity.User;
import it.beije.ananke.model.RubricaEntityManager;




public class JPAmanager {


	public static boolean addUser(User user) {
		EntityManager entityManager = RubricaEntityManager.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		User userBean = user;

			if(user!=null)
			{
			// opening the transaction
			entityTransaction.begin();
			entityManager.persist(user);
			entityTransaction.commit();
			entityManager.close();
	
			return true;
			}
			else return false;
	}

	public static User findUserById(int id)

	{
		EntityManager entityManager = RubricaEntityManager.getEntityManager();
		
		User user = entityManager.find(User.class,id);
		
		entityManager.close();
		
		return user;
	}
	
	public static User findUserByEmail(String email)

	{
		EntityManager entityManager = RubricaEntityManager.getEntityManager();
		
		User user = new User();
		String JPASelect = "SELECT c FROM User as c WHERE email='"+email+"'";
		Query query = entityManager.createQuery(JPASelect);
		
		if(query!=null)
		{
			List<User> users = query.getResultList();
		
			if(!users.isEmpty())
			{
				user = users.get(0);
				
				return user;
			}
		}	
				return null;		
	}
	
	public static boolean emailUsed(String email)

	{
		EntityManager entityManager = RubricaEntityManager.getEntityManager();
		String JPASelect = "SELECT c FROM User as c WHERE email='"+email+"'";
				
		Query query = entityManager.createQuery(JPASelect);
		
		if(query!=null)
		{
			List<User> users = query.getResultList();
		
			if(!users.isEmpty())
			return true;
		}
		return false;
	}
	
	public static List<Product> findAllProduct()
	{
		EntityManager entityManager = RubricaEntityManager.getEntityManager();
		
		String JPASelect = "SELECT c FROM Product as c";
		Query query = entityManager.createQuery(JPASelect);
		List<Product> products = query.getResultList();
		
		return products;
	}
	
	public static List<Order> findOrderByUser(int userId)

	{
		EntityManager entityManager = RubricaEntityManager.getEntityManager();
		
		String JPASelect = "SELECT c FROM Order as c WHERE user_id="+userId;
		Query query = entityManager.createQuery(JPASelect);
		List<Order> orders = query.getResultList();
		if(!orders.isEmpty())
		{
			return orders;
		}
		else return orders=null;	
	}
	
	public static Product findProductById(int id)

	{
		EntityManager entityManager = RubricaEntityManager.getEntityManager();
		
		Product user = entityManager.find(Product.class,id);
		
		entityManager.close();
		
		return user;
	}
	
	public static boolean addOrder(Order order)

	{
		EntityManager entityManager = RubricaEntityManager.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Order toInsert = order;

			if(toInsert!=null)
			{
			// opening the transaction
			entityTransaction.begin();
			entityManager.persist(toInsert);
			entityTransaction.commit();
			entityManager.close();
	
			return true;
			}
			else return false;
	}
	
	public static boolean addOrderItem(OrderItem ordIt)
	{
		EntityManager entityManager = RubricaEntityManager.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		OrderItem toInsert = ordIt;

			if(toInsert!=null)
			{
			// opening the transaction
			entityTransaction.begin();
			entityManager.persist(toInsert);
			entityTransaction.commit();
			entityManager.close();
	
			return true;
			}
			else return false;
	}
//
//	public static boolean eliminaContatto(Contatto contatto) {
//
//		EntityManager entityManager = RubricaEntityManager.getEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//		
//		Contatto cont = cercaContatto(contatto);
//		
//		if(cont!=null)
//		{
//			entityTransaction.begin();
//			entityManager.remove(cont);
//			entityTransaction.commit();
//			entityManager.close();
//			return true;
//		}
//
//		else return false;
//}

//	public static void exportDB() throws Exception {
//		EntityManager entityManager = RubricaEntityManager.getEntityManager();
//		String result, last3, xml = "xml", csv = "txt";
//		String JPASelect = "SELECT c FROM Contatto as c";
//		Query query = entityManager.createQuery(JPASelect);
//		List<Contatto> contatti = query.getResultList();
//
//		System.out.println("Inserisci il path in cui esportare la rubrica:");
//		result = input.nextLine();
//		last3 = result.substring(result.length() - 3);
//
//		if (last3.equals(xml)) {
//			RubricaXML.writeContactXML((ArrayList<Contatto>) contatti, result);
//		} else if (last3.equals(csv)) {
//			Rubrica.writeContacts(new File(result), (ArrayList<Contatto>) contatti);
//		}
//
//		entityManager.close();
//	}
//
//	public static void importOnDB(Scanner input) throws ParserConfigurationException, SAXException, IOException {
//		String path, last3, xml = "xml", csv = "txt";
//		System.out.println("Inserisci il path della rubrica da importare:");
//		path = input.nextLine();
//		last3 = path.substring(path.length() - 3);
//		ArrayList<Contatto> contatti = null;
//
//		if (last3.equals(xml)) {
//			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder builder = factory.newDocumentBuilder();
//			Document document = builder.parse(path);
//			contatti = RubricaXML.readContactsXML(document);
//		} else if (last3.equals(csv)) {
//			contatti = Rubrica.readContacts(new File(path));
//		}
//
//		EntityManager entityManager = RubricaEntityManager.getEntityManager();
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//
//		for (Contatto con : contatti) {
//			entityTransaction.begin();
//			entityManager.persist(con);
//			entityTransaction.commit();
//		}
//		System.out.println("Rubrica importata su db.");
//
//		entityManager.close();
//	}

}
