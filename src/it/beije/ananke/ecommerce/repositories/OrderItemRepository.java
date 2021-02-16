package it.beije.ananke.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.ecommerce.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
