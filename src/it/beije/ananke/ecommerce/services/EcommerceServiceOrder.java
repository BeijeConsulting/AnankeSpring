package it.beije.ananke.ecommerce.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.ecommerce.beans.Cart;
import it.beije.ananke.ecommerce.beans.OrderItem;
import it.beije.ananke.ecommerce.beans.Orders;
import it.beije.ananke.ecommerce.beans.Product;
import it.beije.ananke.ecommerce.beans.User;
import it.beije.ananke.ecommerce.repositories.EcommerceRepositoryOrderItem;
import it.beije.ananke.ecommerce.repositories.EcommerceRepositoryOrders;
import it.beije.ananke.ecommerce.repositories.EcommerceRepositoryProduct;

@Service
public class EcommerceServiceOrder extends EcommerceService{
	
	@Autowired
	private EcommerceRepositoryOrders repoOrder;
	
	@Autowired
	private EcommerceRepositoryOrderItem repoOrderItem;
	
	@Autowired
	private EcommerceRepositoryProduct repoProduct;
	
	public Cart addProductToCart(Cart cart, OrderItem item) {
		
		if(cart == null) {
			//creo un nuovo carrello che poi ritorner al metodo del contrller
			//e che verr� messo in sessione
			cart = new Cart();
			
		}
		
		cart.setItems(item);
		
		return cart;
		
	}
	
	public Cart removeProductFromCart(Cart cart, OrderItem item) {
		
		if(cart != null) {
			
			cart.removeItem(item);
			
			if(cart.getItems().size() == 0)
				//ho svuotato il carrello
				cart = null;
		}
		
		//non dovrebbe succedere di avere il carrello vuoti
		
		
		return cart;
		
	}
	
	public Cart removeItemFromCart(Cart cart, OrderItem item) {
		
		if(cart != null) {
			
			cart.removeProduct(item);
			
			if(cart.getItems().size() == 0)
				//ho svuotato il carrello
				cart = null;
		}
		
		//non dovrebbe succedere di avere il carrello vuoti
		
		
		return cart;
		
	}
	
	public Orders openNewOrder(User user) {
		
		Orders order = new Orders();
		order.setUserId(user.getId());
		order.setState("open");
		
		order = repoOrder.save(order);
		
		return order;
		
	}
	
	public List<Orders> findOpenOrder(Integer userId) {
		
		List<Orders> orders = repoOrder.findByUserIdAndState(userId, "open");
		
		return orders;
		
	}
	
	public Orders findById(Integer orderId) {
		
		Orders order = repoOrder.findById(orderId).get();
		
		return order;
		
	}
	
	public Orders confirmOrder(User user, Cart cart, Orders order) {
		
		Set<OrderItem> items = new HashSet<>(cart.getItems());
		
		//order.setUserId(user.getId());
		
//		for (OrderItem orderItem : items) {
//			//setto order_id per tutti gli item
//			orderItem.setOrderId(order.getId());
//		}
		
		order.setAmount(cart.getAmount());
		order.setItems(items);
		order.setState("closed");

		order = repoOrder.save(order);
		
		return order;
		
	}
	
	public Cart saveOrderItems(Cart cart, Orders order) {
		
		for (OrderItem item : cart.getItems()) {
			item.setOrderId(order.getId());
			repoOrderItem.save(item);
		}
		
		return cart;
		
	}
	
	
	public List<Orders> findByUserId(Integer userId){
		
		List<Orders> userOrders = repoOrder.findByUserId(userId);
		
		return userOrders;
		
	}
	
}
