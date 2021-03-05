package it.beije.ananke.ecommerce.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.beije.ananke.ecommerce.beans.Product;

@Repository
public interface EcommerceRepositoryProduct extends JpaRepository<Product, Integer>{

	public Optional<Product> findById(Integer id);
	
	@Query(value= "SELECT * "
			    + "FROM order_item "
			    + "RIGHT JOIN products "
			    + "ON order_item.product_id = product.id "
			    + "i "
			    + "GROUP BY product_id"
			    + "ORDER BY "
			    + "COUNT(*)", nativeQuery = true)
	public List<Product> findTopProduct();
	
}
