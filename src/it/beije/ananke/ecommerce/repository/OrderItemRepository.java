package it.beije.ananke.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.ecommerce.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<Integer, OrderItem>{
	
}
