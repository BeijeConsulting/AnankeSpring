package it.beije.ananke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.model.Order;
import it.beije.ananke.model.OrderItem;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	public Order findByUserIDAndState(Integer userID, String state);
	public List<Order> findByUserID(Integer userID);
}
