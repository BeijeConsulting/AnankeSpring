package it.beije.ananke.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.beije.ananke.ecommerce.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	
	public List<OrderItem> findByOrderId(Integer OrderId);
	
	public OrderItem findByOrderIdAndProductId(Integer OrderID, Integer ProductId);

	@Query(nativeQuery = true, value ="SELECT SUM(amount) FROM order_item WHERE order_id LIKE :orderId")
	public double totalAmount(@Param("orderId") Integer orderId);

}
