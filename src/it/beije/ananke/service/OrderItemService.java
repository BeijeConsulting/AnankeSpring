package it.beije.ananke.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import it.beije.ananke.entity.OrderItem;
import it.beije.ananke.repository.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public OrderItem findByOrderIdAndProductId(int ordId, int prodId)
	{
		return orderItemRepository.findByOrderIdAndProductId(ordId,prodId);
	}
	
	public List<OrderItem> findAllByOrderId(int ordId){
		
		return orderItemRepository.findAllByOrderId(ordId);
	}
	
	public OrderItem save(OrderItem ordItem)
	{
		return orderItemRepository.save(ordItem);
	}
	
	
	public double totalAmount(int orderId)
	{
		return orderItemRepository.totalAmount(orderId);
	}
	
	public void deleteByOrderId(int orderId)
	{
		List<OrderItem> items = orderItemRepository.findAllByOrderId(orderId);
		
		for(OrderItem el : items)
		{
			orderItemRepository.delete(el);
		}
	}
	
}
