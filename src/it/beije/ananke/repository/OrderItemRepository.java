package it.beije.ananke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.beije.ananke.model.Contatto;
import it.beije.ananke.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>  {
//	public Contatto findBy(String email);
	
	public List<OrderItem> findByOrderID(int orderID);
	
	public OrderItem findByOrderIDAndProductID(int orderID,int productID);
	
}
