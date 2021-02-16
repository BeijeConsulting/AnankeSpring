package it.beije.ananke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import it.beije.ananke.model.Order_items;

@Repository
public interface OrderRepository extends JpaRepository <Order, Integer> {

	public Order findByUser_id(int id);
}