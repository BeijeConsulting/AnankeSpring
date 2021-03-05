package it.beije.ananke.ecommerce.restControllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.ananke.ecommerce.beans.Cart;
import it.beije.ananke.ecommerce.beans.OrderItem;
import it.beije.ananke.ecommerce.beans.Orders;
import it.beije.ananke.ecommerce.beans.User;
import it.beije.ananke.ecommerce.dto.OrderMessage;
import it.beije.ananke.ecommerce.services.EcommerceServiceOrder;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class EcommerceRestContollerOrder{
	
	@Autowired
	private EcommerceServiceOrder serviceOrder;

	@GetMapping("/ecommerce/myOrders/{userId}")
	public List<Orders> getViewOrders(@PathVariable Integer userId) {
		
		//user dovrei prenderlo dalla sessione
		//User user = (User) session.getAttribute("user");
		
		List<Orders> userOrders = serviceOrder.findByUserId(userId);
		
		//model.addAttribute("orders", userOrders);
		
		return userOrders;
	}
	
	@PostMapping("/ecommerce/openOrder")
	public Orders openOrder(HttpSession session) {
		//apro l'ordine		
		User user = (User) session.getAttribute("user");
		
		Orders order = serviceOrder.openNewOrder(user);
		
		//metto l'ordine nella sessione
		session.setAttribute("order", order);
		
		return order;
		
	}
	
	//FUNZIONA, ma prendi i singoli parametri
//	@PostMapping("/ecommerce/addProduct/{productId}/{quantity}/{amount}")
//	public Cart addProduc(@PathVariable Integer productId, @PathVariable Integer quantity, @PathVariable Integer amount, HttpSession session) {
	@PutMapping("/ecommerce/addProduct/{productId}/{quantity}/{amount}")
	public Cart addProduc(@PathVariable Integer productId, @PathVariable Integer quantity, @PathVariable Double amount, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		Cart cart = (Cart) session.getAttribute("cart");
		
		OrderItem item = new OrderItem();
		item.setProductId(productId);
		item.setQuantity(quantity);
		item.setAmount(amount);
		
		cart = serviceOrder.addProductToCart(cart, item);
		
		return cart;
		
	}
	
	@DeleteMapping("/ecommerce/removeProduct{productId}{quantity}{amount}")
	public Cart removeProduct(@PathVariable OrderItem item, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		Cart cart = (Cart) session.getAttribute("cart");
		
		cart = serviceOrder.removeProductToCart(cart, item);
		
		return cart;
		
	}
	
	
	@PostMapping("/ecommerce/confirmedOrder")
	public OrderMessage postConfirm(Model model, HttpSession session) {
		
		//nella session ho:
		//	utente
		//	carrello con
		//		lista degli orderItem
		//		totale da pagare
		User user = (User) session.getAttribute("user");
		Cart cart = (Cart) session.getAttribute("cart");
		Orders order = (Orders) session.getAttribute("order");
		
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
		
		return message;
	}
	
}
