package it.beije.ananke.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.ecommerce.Cart;
import it.beije.ananke.ecommerce.CartItem;
import it.beije.ananke.ecommerce.Order;
import it.beije.ananke.ecommerce.OrderItem;
import it.beije.ananke.ecommerce.repository.OrderItemRepository;
import it.beije.ananke.ecommerce.repository.OrderRepository;
import it.beije.ananke.ecommerce.repository.ProductRepository;
import it.beije.ananke.ecommerce.repository.UserRepository;

@Service
public class CartService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderItemRepository orderItemRepo;
	
	
	public Cart makeCart(String userId) {
		List<Order> listOrders = orderRepo.findByStateAndUserId("open", Integer.valueOf(userId));
		Order order;
		Cart cart = new Cart();
		
		if(listOrders.size() == 0) {
			order = new Order();
			order.setState("open");
			order.setUserId(Integer.parseInt(userId));
			orderRepo.save(order);
		}else {
			order = listOrders.get(0);
			
		}
		
		cart.setUser(userRepo.findById(Integer.valueOf(userId)).get());
		cart.setOrder(order);		
		return cart;
	}
	
	public Cart showCart(String userId) {
		Cart cart = makeCart(userId);
		List<OrderItem> listItems = new ArrayList<>();
		listItems = orderItemRepo.findByOrderId(cart.getOrder().getId());
		cart.setList(toProducts(listItems));
		return cart;
	}
	
	
	public List<CartItem> toProducts(List<OrderItem> items){
		List<CartItem> products = new ArrayList<>();
		for(OrderItem i : items) {
			CartItem c = new CartItem();
			c.setOrderItemId(i.getId());
			c.setName(productRepo.findById(i.getProductId()).get().getName());
			c.setAmount(i.getAmount());
			c.setQuantity(i.getQuantity());
			products.add(c);
		}
		return products;
	}
	
}
