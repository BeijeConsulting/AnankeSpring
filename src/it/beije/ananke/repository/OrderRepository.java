package it.beije.ananke.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.ananke.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}