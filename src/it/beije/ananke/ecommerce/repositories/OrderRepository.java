package it.beije.ananke.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.ananke.ecommerce.model.Order;
import it.beije.ananke.ecommerce.util.OrderState;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	public List<Order> findByUserId(Integer id);
	
	public Order findByUserIdAndState(Integer userId, String state);
	
	
	@Query(nativeQuery = true, value="SELECT product.name,product.price,order_item.quantity,order_item.amount\r\n"
			+ "FROM product JOIN order_item ON order_item.product_id = product.id\r\n"
			+ "WHERE order_id =:orderId;")
	public List getCart(@Param("ordId")Integer orderId);
	
}
