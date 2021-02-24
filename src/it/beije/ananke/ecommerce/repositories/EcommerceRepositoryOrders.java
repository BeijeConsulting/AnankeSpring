package it.beije.ananke.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.ecommerce.beans.Orders;

@Repository
public interface EcommerceRepositoryOrders extends JpaRepository<Orders, Integer>{

	public List<Orders> findByUserId(Integer userId);

	public List<Orders> findByUserIdAndState(Integer userId, String state);
	
}
