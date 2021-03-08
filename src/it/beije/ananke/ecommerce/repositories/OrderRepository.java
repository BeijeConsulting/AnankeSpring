package it.beije.ananke.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.ecommerce.model.Order;
import it.beije.ananke.ecommerce.util.OrderState;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	public List<Order> findByUserId(Integer id);
	
	public Order findByUserIdAndState(Integer userId, String state);
	
	
}
