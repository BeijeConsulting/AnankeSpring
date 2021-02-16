package it.beije.ananke.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.ecommerce.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	public List<Order> findByUserId(Integer id);
	
	public Order findByUserIdAndState(Integer id, String state);
}
