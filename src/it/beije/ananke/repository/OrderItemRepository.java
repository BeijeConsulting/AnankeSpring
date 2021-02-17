package it.beije.ananke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{
	
	public List<OrderItem> findByOrderId(Integer orderId);
	
	public OrderItem save(OrderItem item);
	
	public OrderItem findByOrderIdAndProductId(Integer orderId, Integer productId);
	
	public void delete(OrderItem item);
}
