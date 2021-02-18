package it.beije.ananke.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.ananke.model.Order_items;
import it.beije.ananke.model.User;

@Repository
public interface Order_itemsRepository extends JpaRepository <Order_items, Integer> {
	@Query(nativeQuery = true, value = "SELECT * FROM order_items WHERE order_id = order_id")
	public List<Order_items> findByOrder_id(@Param("order_id") Integer order_id);
	
	@Query(nativeQuery = true, value = "delete from order_items WHERE product_id = id")
	public void delete(@Param("id") Integer id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM order_items WHERE order_id = order_id AND product_id = product_id")
	public Order_items findByProduct_id(@Param("order_id") Integer order_id, @Param("product_id") Integer product_id);
	
	
}