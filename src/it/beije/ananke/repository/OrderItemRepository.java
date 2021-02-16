package it.beije.ananke.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
