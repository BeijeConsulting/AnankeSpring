package it.beije.ananke.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.model.Order;
import it.beije.ananke.repository.OrderRepository;

@Service
public class OrderService {
@Autowired
private OrderRepository orderRepository;

	
	
	public List<Order> findByUserID(Integer userID) {
		return orderRepository.findByUserID(userID);
		
	}
	public void changeStateClose(Order c) {
		c.setState("close");
		orderRepository.save(c);
	}
	public Order findByUserIDAndState(Integer userID, String state) {
		return orderRepository.findByUserIDAndState(userID, state);
	}
}
