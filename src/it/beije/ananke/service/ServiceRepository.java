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
	
	public void newItems(Integer idItems, int quantity) {
		
		Order_items oggetto = new Order_items();
		oggetto.setProduct_id(idItems);
		oggetto.setAmount(amountProduct(idItems, quantity));
		oggetto.setQuantity(quantity);
		orderepository.save(oggetto);
	}
	public boolean isItemsinCart(Integer order_id, Integer product_id) {
	      Order_items oggetto = orderepository.findByProduct_id(order_id,product_id);
	      if(oggetto == null) {
	    	  System.out.println("prodotto nuovo");
	    	  return false;
	      }else {
	    	  System.out.println("prodotto già presente");
	    	  return true;
	      }
	}
	public void saveorderitems(HttpSession session, int quantity, int idItems) {
		User user = (User) session.getAttribute("utente");
		Integer iduser = user.getId();
		Order_items oggetto = new Order_items();
		Order or = ordpository.searchOrderofUser_id(iduser, "on");
		double amount = amountProduct(idItems, quantity);
		if(or == null) {
			newOrderItems(session,quantity,idItems);
			session.setAttribute("ordine", or);
		}else {
			oggetto = orderepository.findByProduct_id(or.getId(), idItems);
			if(!isItemsinCart(or.getId(), idItems)) {
				newItems(idItems,quantity);	
				or.setAmount(amount);
			} else {
				//oggetto.setAmount(amount);
				int quantita = oggetto.getQuantity();
				quantita = quantita + quantity;
				double amoutP = quantita * searchProduct(idItems).getPrice();
				oggetto.setAmount(amoutP);
				oggetto.setQuantity(quantita);
				double amountOrder = or.getAmount();
				amountOrder = amountOrder + amoutP;
				or.setAmount(amountOrder);
				orderepository.save(oggetto);
			}
			
		}
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
