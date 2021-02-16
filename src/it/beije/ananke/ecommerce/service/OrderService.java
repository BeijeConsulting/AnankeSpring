package it.beije.ananke.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.ecommerce.model.Order;
import it.beije.ananke.ecommerce.model.OrderItem;
import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.repositories.OrderItemRepository;
import it.beije.ananke.ecommerce.repositories.OrderRepository;

@Service
public class OrderService {
	public static final String OPEN = "open";
	public static final String CLOSE = "close";
	
	@Autowired
	OrderRepository orderRepository;
	
	public boolean checkOpenOrder(User user){
		List<Order> orders = orderRepository.findByUserId(user.getId());
		if(!orders.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public Order openOrder(User user) {
		Order order;
		if(checkOpenOrder(user)) {
			order = orderRepository.findByUserIdAndState(user.getId(), OPEN);
		} else {
			order = new Order();
			order.setUserId(user.getId());
			order.setState(OPEN);
			order.setAmount(0.0);
			orderRepository.save(order);
		}
		return order;	
	}
	
	public void updatePrice(Order order, OrderItem orderItem) {
		order.setAmount(order.getAmount()+orderItem.getAmount());
		orderRepository.save(order);
	}
}
