package it.beije.ananke.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.ecommerce.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	
	public List<OrderItem> findByOrderId(Integer OrderId);
	
	public OrderItem findByOrderIdAndProductId(Integer OrderID, Integer ProductId);

}
