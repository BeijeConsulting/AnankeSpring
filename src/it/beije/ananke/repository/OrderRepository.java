package it.beije.ananke.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.model.Order;
import it.beije.ananke.model.OrderItem;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
