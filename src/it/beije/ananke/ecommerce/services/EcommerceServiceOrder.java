package it.beije.ananke.ecommerce.services;

import java.util.List;

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
			//e che verrà messo in sessione
			cart = new Cart();
			
		}
		
		cart.setItems(item);
		
		return cart;
		
	}
	
	public Orders saveNewOrder(User user, Cart cart) {
		
		Orders order = new Orders();
		
		order.setUseId(user.getId());
		order.setAmount(cart.getAmount());
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
