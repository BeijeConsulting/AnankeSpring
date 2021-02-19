package it.beije.ananke.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.beije.ananke.ecommerce.model.Chart;

public interface ChartRepository extends JpaRepository<Chart, Integer> {

	public List<Chart> findByUserId (Integer userId);
	
	public List<Chart> findByOrderId (Integer orderId);
	
	public Chart findByOrderIdAndProductId(Integer orderId, Integer productId);
	
	@Query(nativeQuery = true, value = "DELETE FROM chart WHERE order_id LIKE :orderId")
	public void deleteByOrderId(@Param ("orderId") Integer orderId);
}
