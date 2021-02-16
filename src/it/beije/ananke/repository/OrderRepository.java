package it.beije.ananke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	public List<Order> findByUserId(int id);
}
