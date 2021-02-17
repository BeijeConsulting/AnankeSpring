package it.beije.ananke.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.ananke.ecommerce.Order;
import it.beije.ananke.ecommerce.OrderItem;
import it.beije.ananke.ecommerce.repository.OrderItemRepository;
import it.beije.ananke.ecommerce.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public List<Order> findByUserId(Integer userId) {
		return orderRepository.findByUserId(userId);
	}
	
	public Order save(Order order, Integer userId) {
		List<Order> listOrder = findByUserId(userId);
		
		if(!listOrder.isEmpty()) {
			for(Order ord : listOrder) {
				if(ord.getState().equals("in progress")) {
					return ord;
				}
			}
		}
		return orderRepository.save(order);
	}
	
	public OrderItem save(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}
	

	public List<OrderItem> findByOrder(Integer id){
			return orderItemRepository.findByOrder(id);
	}
}
