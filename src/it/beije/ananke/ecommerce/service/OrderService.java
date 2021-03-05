package it.beije.ananke.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.ecommerce.model.Order;
import it.beije.ananke.ecommerce.model.OrderItem;
import it.beije.ananke.ecommerce.model.User;
import it.beije.ananke.ecommerce.repositories.OrderItemRepository;
import it.beije.ananke.ecommerce.repositories.OrderRepository;
import it.beije.ananke.ecommerce.util.OrderState;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public boolean checkOpenOrder(User user){
		List<Order> orders = orderRepository.findByUserId(user.getId());
		System.out.println(orders.toString());
		if(!orders.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public Order openOrder(User user) {
		Order order;
		if(checkOpenOrder(user)) {
			order = orderRepository.findByUserIdAndState(user.getId(), OrderState.OPEN);
			if (order == null) {
				order = new Order();
				order.setUserId(user.getId());
				order.setState(OrderState.OPEN);
				order.setAmount(0.0);
				orderRepository.save(order);
			}
		} else {
			order = new Order();
			order.setUserId(user.getId());
			order.setState(OrderState.OPEN);
			order.setAmount(0.0);
			orderRepository.save(order);
		}
		return order;	
	}
	
	public void updatePrice(Order order, OrderItem orderItem) {
		order.setAmount(order.getAmount()+orderItem.getAmount());
		orderRepository.save(order);
	}
	
	public List<Order> findByUserId (Integer userId) {
		return orderRepository.findByUserId(userId);
	}
}
