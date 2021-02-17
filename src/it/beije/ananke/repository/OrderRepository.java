package it.beije.ananke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	public List<Order> findByStateAndUserId(String state, Integer userId);
	
	public Order save(Order order);
}
