package it.beije.ananke.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.entity.Order;
import it.beije.ananke.repository.OrderItemRepository;
import it.beije.ananke.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	public List<Order> findByUserId(int id)
	{
		return orderRepository.findByUserId(id);
	}
	
	public Order save(Order order)
	{
		return orderRepository.save(order);
	}
	
	public Order findById(int id)
	{
		Optional<Order> ord = orderRepository.findById(id);
		
		return ord.get();
	}
	
	public void updateStatus(int id)
	{
		Order order = orderRepository.findById(id).get();
		
		order.setState("cancelled");
		
		orderRepository.save(order);
	}
	
}
