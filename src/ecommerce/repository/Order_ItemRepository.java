package ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.entity.Order_Item;

public interface Order_ItemRepository extends JpaRepository<Order_Item, Integer> {

}
