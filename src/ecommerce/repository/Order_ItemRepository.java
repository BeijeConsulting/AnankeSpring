package ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ecommerce.entity.Order_Item;

public interface Order_ItemRepository extends JpaRepository<Order_Item, Integer> {


}
