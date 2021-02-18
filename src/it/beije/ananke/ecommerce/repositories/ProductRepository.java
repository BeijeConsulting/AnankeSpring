package it.beije.ananke.ecommerce.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.beije.ananke.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query(nativeQuery = true, value = "SELECT product.id, name, description, price FROM product INNER JOIN order_item" +
			" ON  product.id = order_item.product_id WHERE order_id LIKE :orderId")
	public List<Product> findItemsByOrderId(@Param ("orderId") Integer orderId);

}
