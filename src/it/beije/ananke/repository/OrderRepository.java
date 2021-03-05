package it.beije.ananke.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.ananke.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	public List<Order> findByUserId(int id);
	
	@Query(nativeQuery = true, value ="SELECT * FROM orders WHERE user_id =:id AND state LIKE :state")
	public Order findByUserIdAndOrderOpen(@Param("id")int id,@Param("state") String state);

}
