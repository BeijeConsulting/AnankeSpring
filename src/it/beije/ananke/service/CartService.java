package it.beije.ananke.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.model.Cart;
import it.beije.ananke.model.CartItem;
import it.beije.ananke.model.Order;
import it.beije.ananke.model.OrderItem;
import it.beije.ananke.model.Product;
import it.beije.ananke.repository.OrderItemRepository;
import it.beije.ananke.repository.OrderRepository;
import it.beije.ananke.repository.ProductRepository;
import it.beije.ananke.repository.UserRepository;

@Service
public class CartService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public Cart makeCart(String userId) {
		List<Order> listOrders = orderRepository.findByStateAndUserId("open", Integer.valueOf(userId));
		Order order;
		Cart cart = new Cart();
		
		if(listOrders.size() == 0) {
			order = new Order();
			order.setState("open");
			order.setUserId(Integer.parseInt(userId));
			orderRepository.save(order);
		}else {
			order = listOrders.get(0);
			
		}
		
		cart.setUser(userRepository.findById(Integer.valueOf(userId)).get());
		cart.setOrder(order);		
		return cart;
	}
	
	public Cart showCart(String userId) {
		Cart cart = makeCart(userId);
		List<OrderItem> listItems = new ArrayList<>();
		listItems = orderItemRepository.findByOrderId(cart.getOrder().getId());
		cart.setList(toProducts(listItems));
		return cart;
	}
	
	
	public Cart addToCart(String userId, String productId) {
		Cart cart = makeCart(userId);
		Product product = productRepository.findById(Integer.valueOf(productId)).get();
		List<OrderItem> listItems = orderItemRepository.findByOrderId(cart.getOrder().getId());
		
		//check item è già presente nel carrello
		OrderItem item = orderItemRepository.findByOrderIdAndProductId(cart.getOrder().getId(), product.getId());
		if(item == null) {
			System.out.println("non c'è");
			item = new OrderItem();
			item.setOrderId(cart.getOrder().getId());
			item.setProductId(product.getId());
			item.setQuantity(1);
			item.setAmount(product.getPrice()*item.getQuantity());
			cart.getOrder().setAmount(cart.getOrder().getAmount() + item.getAmount());
			orderRepository.save(cart.getOrder());
			orderItemRepository.save(item);
			
			listItems.add(item);
		}else {
			System.out.println("c'è già");
			for(OrderItem o : listItems) {
				System.out.println("WIIIII");
				if(item.getId() == o.getId()) {
					o.setQuantity(o.getQuantity() + 1);
					System.out.println(o.getQuantity());
					o.setAmount(product.getPrice()*o.getQuantity());
					System.out.println(o.getAmount());
					cart.getOrder().setAmount(cart.getOrder().getAmount() + product.getPrice());
					orderRepository.save(cart.getOrder());
					orderItemRepository.save(o);
				}
			}
		}
		
		cart.setList(toProducts(listItems));
		return cart;
	}
	
	
	
	public Cart removeFromCart(String userId, String orderItemId) {
		Cart cart = makeCart(userId);
		List<OrderItem> listItems = orderItemRepository.findByOrderId(cart.getOrder().getId());
		OrderItem item = orderItemRepository.findById(Integer.parseInt(orderItemId)).get();
		//Product product = productRepository.findById(Integer.valueOf(productId)).get();
		if(listItems.size() == 0) {
			return null;
		}else {
			for(OrderItem o : listItems) {
				if(o.getProductId() == item.getProductId()) {
					if(o.getQuantity() <= 1) {
						orderItemRepository.delete(listItems.remove(listItems.indexOf(o)));
					}else {
						double one = o.getAmount()/o.getQuantity();
						o.setQuantity(o.getQuantity() - 1);
						o.setAmount(one*o.getQuantity());
						orderItemRepository.save(o);
					}
				}
			}
			cart.setList(toProducts(listItems));
			return cart;
		}
	}
	
	
	public List<CartItem> toProducts(List<OrderItem> items){
		List<CartItem> products = new ArrayList<>();
		for(OrderItem i : items) {
			CartItem c = new CartItem();
			c.setOrderItemId(i.getId());
			c.setName(productRepository.findById(i.getProductId()).get().getName());
			c.setAmount(i.getAmount());
			c.setQuantity(i.getQuantity());
			products.add(c);
		}
		return products;
	}
	
	

}
