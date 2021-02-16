package it.beije.ananke.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.ecommerce.beans.OrderItem;

@Repository
public interface EcommerceRepositoryOrderItem extends JpaRepository<OrderItem, Integer>{

}
