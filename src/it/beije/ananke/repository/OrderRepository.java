package it.beije.ananke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.ananke.model.Order;
import it.beije.ananke.model.Order_items;

@Repository
public interface OrderRepository extends JpaRepository <Order, Integer> {
	@Query(nativeQuery = true, value = "SELECT * FROM orders WHERE user_id = user_id  AND state = state")
	public Order searchOrderofUser_id(@Param("user_id") Integer user_id , @Param("state") String state);
}