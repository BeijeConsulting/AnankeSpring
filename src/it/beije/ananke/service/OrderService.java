package it.beije.ananke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import it.beije.ananke.model.Order;
import it.beije.ananke.repository.OrderRepository;

public class OrderService {


	@Autowired
	OrderRepository orderRepository;

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public void save(Order order) {
		orderRepository.save(order);
	}
	
	public Order findByUserId(Integer userId) {
		return orderRepository.findByUserId(userId);
	}

	
	
}
