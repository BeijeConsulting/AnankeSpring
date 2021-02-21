package it.beije.ananke.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.model.Order;
import it.beije.ananke.model.Order_items;
import it.beije.ananke.model.Product;
import it.beije.ananke.model.User;
import it.beije.ananke.repository.OrderRepository;
import it.beije.ananke.repository.Order_itemsRepository;
import it.beije.ananke.repository.ProductRepository;
import it.beije.ananke.repository.UserRepository;

@Service
public class ServiceRepository {

	@Autowired
	private UserRepository userepository;
	@Autowired
	private Order_itemsRepository orderepository;
	@Autowired
	private OrderRepository ordpository;
	@Autowired
	private ProductRepository productrepository;


	public User findByEmailAndPassword(String email, String password) {
		return userepository.findByEmailAndPassword(email, password);
	}
	
	public User findByEmail(String email) {
		return userepository.findByEmail(email);
	}

	public void save(User s) {
		userepository.save(s);
	}

	public void modifyProfile(User user) {

		userepository.save(user);
	}

	public Product searchProduct(Integer id) {
		Optional<Product> p = productrepository.findById(id);
		return p.get();
	}

	public List<Product> getlistaProdotti() {
		return productrepository.findAll();
	}

	public double amountProduct(Integer idProduct, int quantity) {
	   Product p = searchProduct(idProduct);
	   double price = p.getPrice();
	   return price * quantity;
	}
	
	public void newOrderItems(HttpSession session,  int quantity, int idItems) {
		User user = (User) session.getAttribute("utente");
		Order_items oggetto = new Order_items();
		Order ordine = new Order();
		Integer iduser = user.getId();
		double amount = amountProduct(idItems, quantity);
		ordine.setUser_id(iduser);
		ordine.setState("on");
		ordpository.save(ordine);
		session.setAttribute("ordine", ordine);
		ordine = ordpository.searchOrderofUser_id(iduser, "on");
		ordine.setAmount(amount);
		ordpository.save(ordine);
		oggetto.setProduct_id(idItems);
		oggetto.setQuantity(quantity);
		oggetto.setAmount(amount);
		oggetto.setOrder_id(ordine.getId());
		orderepository.save(oggetto);
	}
	
	public void newItems(Integer idItems, int quantity, int orid) {
		Order_items oggetto = new Order_items();
		oggetto.setProduct_id(idItems);
		oggetto.setOrder_id(orid);
		oggetto.setAmount(amountProduct(idItems, quantity));
		oggetto.setQuantity(quantity);
		orderepository.save(oggetto);
	}
	public boolean isItemsinCart(Integer order_id, Integer idItems) {
		Order_items oggetto1 = orderepository.findByOrder_idAndProduct_id(order_id, idItems);
	      if(oggetto1 == null) {
	    	  return false;
	      }else {
	    	  return true;
	      }
	}
	
	public void AggiornaItemsCart(int quantity, int idItems,Order or) {
		Order_items oggetto = orderepository.findByOrder_idAndProduct_id(or.getId(), idItems);
		int quantita = quantity + oggetto.getQuantity();
//		double amoutP = quantity * searchProduct(idItems).getPrice();
		double amoutP = quantity * oggetto.getAmount();
		System.out.println("il prezzo aggiornato è: " + amoutP);
		oggetto.setAmount(amoutP);
		oggetto.setQuantity(quantita);
		orderepository.save(oggetto);
	}
	
	public void saveorderitems(HttpSession session, int quantity, int idItems) {
		User user = (User) session.getAttribute("utente");
		Integer iduser = user.getId();
		Order or = ordpository.searchOrderofUser_id(iduser, "on");
		double amount = amountProduct(idItems, quantity);
		if(or == null) {
			newOrderItems(session,quantity,idItems);
			session.setAttribute("ordine", or);
		}else {
			if(!isItemsinCart(or.getId(), idItems)){
				newItems(idItems,quantity,or.getId());	
				or.setAmount(amount+ SommaCarrello(session));
				ordpository.save(or);
			}else {
				AggiornaItemsCart(quantity,idItems,or);
				or.setAmount(amount + SommaCarrello(session));
				ordpository.save(or);
			}
			
		}
	
	}

	public double SommaCarrello(HttpSession session) {
		User user = (User)session.getAttribute("utente");
		Order or =  ordpository.searchOrderofUser_id( user.getId(), "on");
		return or.getAmount();
	}
	
	public void deleteFromcart(Integer idProduct, HttpSession session) {
		User user = (User) session.getAttribute("utente");
		modificaAmountCart(user.getId(),idProduct);
		orderepository.delete(idProduct);
	}
	
	public double getPrezzoProdotto(Integer idProduct) {
		Product p = searchProduct(idProduct);
		return p.getPrice();
	}
	
	public Order getOrder(Integer iduser) {
		return ordpository.searchOrderofUser_id(iduser, "on");

	}
	
	public double getAmountCart(Integer iduser) {
		Order ordine = ordpository.searchOrderofUser_id(iduser, "on");
		return ordine.getAmount();
		}
	
	public void modificaAmountCart(Integer iduser, Integer idProduct ) {
		double priceProduct = getPrezzoProdotto(idProduct);
		double pricetot = getAmountCart(iduser);
		Order ordine = ordpository.searchOrderofUser_id(iduser, "on");
		double result = pricetot - priceProduct;
		ordine.setAmount(result);
		ordpository.save(ordine);
		
		
		
		
	}
	
	
	public ArrayList<Product> getItemsCart(Order or) {
		 List<Order_items> listaItems =  orderepository.findByOrder_id(or.getId());
		 ArrayList<Product> listaprodotti = new ArrayList<>();
		 for(Order_items s: listaItems) {
			 Optional<Product> p = productrepository.findById(s.getProduct_id());
			 listaprodotti.add(p.get());
		 }
		 return listaprodotti;
 	}
}
