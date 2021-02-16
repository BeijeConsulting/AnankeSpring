package it.beije.ananke.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.ecommerce.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	public Order findByUserId(Integer userId);
}
