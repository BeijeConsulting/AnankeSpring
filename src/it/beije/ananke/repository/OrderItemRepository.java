package it.beije.ananke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.entity.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

	public OrderItem findByOrderIdAndProductId(int ordId, int prodId);
	
	public List<OrderItem> findAllByOrderId(int ordId);
}
