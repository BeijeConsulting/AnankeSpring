package it.beije.ananke.ecommerce.restControllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.ecommerce.beans.Cart;
import it.beije.ananke.ecommerce.beans.OrderItem;
import it.beije.ananke.ecommerce.beans.Orders;
import it.beije.ananke.ecommerce.beans.User;
import it.beije.ananke.ecommerce.dto.OrderMessage;
import it.beije.ananke.ecommerce.services.EcommerceServiceOrder;
import it.beije.ananke.ecommerce.services.EcommerceServiceProduct;
import it.beije.ananke.ecommerce.services.EcommerceServiceUser;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class EcommerceRestContollerOrder{
	
	@Autowired
	private EcommerceServiceOrder serviceOrder;
	
	@Autowired
	private EcommerceServiceUser serviceUser;
	
	@Autowired
	private EcommerceServiceProduct serviceProduct;
	
	private static Cart carrello = null;
	
	private static Orders ordine = null;

	@GetMapping("/ecommerce/myOrders/{userId}")
	public List<Orders> getViewOrders(@PathVariable Integer userId) {
		
		//user dovrei prenderlo dalla sessione
		//User user = (User) session.getAttribute("user");
		
		List<Orders> userOrders = serviceOrder.findByUserId(userId);
		
		//model.addAttribute("orders", userOrders);
		
		return userOrders;
	}
	
	@PostMapping("/ecommerce/openOrder/{userId}")
	public Orders openOrder(@PathVariable Integer userId, HttpSession session) {
		//apro l'ordine		
		//User user = (User) session.getAttribute("user");
		
		User user = serviceUser.findById(userId);
		
		Orders order = serviceOrder.openNewOrder(user);

		//metto l'ordine nella sessione
		session.setAttribute("order", order);
		ordine = order;
		
		return order;
		
	}
	
	//FUNZIONA, ma prendi i singoli parametri
//	@PostMapping("/ecommerce/addProduct/{productId}/{quantity}/{amount}")
//	public Cart addProduc(@PathVariable Integer productId, @PathVariable Integer quantity, @PathVariable Integer amount, HttpSession session) {
	@PutMapping("/ecommerce/addProduct/{productId}/{quantity}")
	public Cart addProduc(@PathVariable Integer productId, @PathVariable Integer quantity, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		//Cart cart = (Cart) session.getAttribute("cart");
		
		Cart cart = carrello;
		
		//risalgo all'amount andando a prendere il prezzo di un singolo prodotto avendo l'id
		Double price = serviceProduct.findById(productId).getPrice();
		Double amount = quantity.intValue() * price.doubleValue();
		
		OrderItem item = new OrderItem();
		item.setProductId(productId);
		item.setQuantity(quantity);
		item.setAmount(amount);
		
		cart = serviceOrder.addProductToCart(cart, item);
		System.out.println(cart);
		
		session.setAttribute("cart", cart);
		carrello = cart;
		
		return cart;
		
	}
	
	@DeleteMapping("/ecommerce/removeProduct/{productId}/{quantity}")
	public List<OrderItem> removeItem(@PathVariable Integer productId, @PathVariable Integer quantity, HttpSession session) {
		//TODO: togliere amount e metterlo nella logica (prendere il costo dal db.
		User user = (User) session.getAttribute("user");
		//Cart cart = (Cart) session.getAttribute("cart");
		Cart cart = carrello;
		
		Double price = serviceProduct.findById(productId).getPrice();
		Double amount = quantity.intValue() * price.doubleValue();
		
		OrderItem item = new OrderItem();
		item.setProductId(productId);
		item.setQuantity(quantity);
		item.setAmount(amount);
		
		cart = serviceOrder.removeProductFromCart(cart, item);
		
		session.setAttribute("cart", cart);
		carrello = cart;
		
		if (cart != null) {
			
			return cart.getItems();
			
		} else return null;
		
	}
	
	@DeleteMapping("/ecommerce/removeProduct/{productId}")
	public List<OrderItem> removeProduct(@PathVariable Integer productId, HttpSession session) {
		//TODO: togliere amount e metterlo nella logica (prendere il costo dal db.
		User user = (User) session.getAttribute("user");
		//Cart cart = (Cart) session.getAttribute("cart");
		Cart cart = carrello;
		
		OrderItem item = new OrderItem();
		item.setProductId(productId);
		
		cart = serviceOrder.removeItemFromCart(cart, item);
		
		session.setAttribute("cart", cart);
		carrello = cart;
		
		if (cart != null) {
			
			return cart.getItems();
			
		} else return null;
		
	}
	
	@GetMapping("/ecommerce/getOrderItems")
	public List<OrderItem> getItems(HttpSession session){
		
		//prendo il carrello dalla sessione
		Cart cart = (Cart) session.getAttribute("cart");
		
		cart = carrello;
		
		System.out.println(cart);
		//ritorno la lista degli orderItem dal carrello
		if (cart != null) {
			
			return cart.getItems();
			
		} else return null;
		
	}
	
	@GetMapping("/ecommerce/getItemsFromOrder/{orderId}")
	public Set<OrderItem> getItemsFromOrder(@PathVariable Integer orderId){
		
		Orders order = serviceOrder.findById(orderId);
		Set<OrderItem> items = order.getItems();
		 
		return items;
	}
	
	@PostMapping("/ecommerce/confirmedOrder/{userId}")
	public List<Orders> postConfirm(@PathVariable Integer userId, Model model, HttpSession session) {
		
		//nella session ho:
		//	utente
		//	carrello con
		//		lista degli orderItem
		//		totale da pagare
		//User user = (User) session.getAttribute("user");
		User user = serviceUser.findById(userId);
		
		//Cart cart = (Cart) session.getAttribute("cart");
		Cart cart = carrello; 
		//Orders order = (Orders) session.getAttribute("order");
		Orders order = ordine;
		
		//inserisco tutti gli orderItems
		serviceOrder.saveOrderItems(cart, order);
		
		order = serviceOrder.confirmOrder(user, cart, order);
		
		OrderMessage message = new OrderMessage();
		message.setOrder(order);
		message.setMessage("orderClosed");

		//serviceOrder.setAllProductToModel(model);
		model.addAttribute("firstName", user.getFirstName());
		model.addAttribute("seeCart", false);
		
		session.setAttribute("cart", null);
		
		carrello = null;
		ordine = null;
		
		//per comodit� una volta confermato l'ordine rid� sottoforma di json tutta 
		//la lista degli ordini
		List<Orders> userOrders = serviceOrder.findByUserId(user.getId());
		
		return userOrders;
		
	}
	
}
