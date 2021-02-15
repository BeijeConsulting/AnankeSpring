package ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
