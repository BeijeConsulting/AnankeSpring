package it.beije.ananke.ecommerce.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import it.beije.ananke.ecommerce.beans.Cart;
import it.beije.ananke.ecommerce.beans.OrderItem;
import it.beije.ananke.ecommerce.beans.Orders;
import it.beije.ananke.ecommerce.beans.User;
import it.beije.ananke.ecommerce.services.EcommerceServiceOrder;

@Controller
public class ControllerEcommerceOrder {
	
	@Autowired
	private EcommerceServiceOrder serviceOrder;
	
	//che richieste fa? 
	//gestisce l'ordine di un cliente
	//quindi quando riceve i dati di un prodotto da aggiungere al carrello
	//prende i dati e li invia 
	
	@RequestMapping(value = "/ecommerce/addProduct{productId}{quantity}{amount}", method = RequestMethod.POST)
	public String postAddProduct(OrderItem item,  Model model, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		Cart cart = (Cart) session.getAttribute("cart");
		
		cart = serviceOrder.addProductToCart(cart, item);
	
		serviceOrder.setAllProductToModel(model);
		
		session.setAttribute("cart", cart);
		session.setAttribute("amount", cart.getAmount());
		model.addAttribute("user", user);
		model.addAttribute("firstName", user.getFirstName());
		model.addAttribute("seeCart", true);
		
		return "ecommerceHomePage";
	}
	
	@RequestMapping(value = "/ecommerce/buy", method = RequestMethod.POST)
	public String postBuy(HttpSession session) {
		//mi manda alla pagina riassuntiva dell'ordine per procedere
		return "ecommerceConfirmOrder";
	}
	
	@RequestMapping(value = "/ecommerce/confirmedOrder", method = RequestMethod.POST)
	public String postConfirm(Model model, HttpSession session) {
		
		//nella session ho:
		//	utente
		//	carrello con
		//		lista degli orderItem
		//		totale da pagare
		User user = (User) session.getAttribute("user");
		Cart cart = (Cart) session.getAttribute("cart");
		
		//inserisco il nuovo ordine nel db Orders
		Orders order = serviceOrder.saveNewOrder(user, cart);
		
		//inserisco tutti gli orderItems ora che ho l'id dell'ordine
		serviceOrder.saveOrderItems(cart, order);
		
		serviceOrder.setAllProductToModel(model);
		model.addAttribute("firstName", user.getFirstName());
		model.addAttribute("seeCart", false);
		
		session.setAttribute("cart", null);
		
		return "ecommerceHomePage";
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getViewOrders(HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		
		List<Orders> userOrders = serviceOrder.findByUserId(user.getId());
		
		return "ecommerceViewOrders";
	}

}