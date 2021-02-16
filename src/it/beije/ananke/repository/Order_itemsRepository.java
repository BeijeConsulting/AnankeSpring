package it.beije.ananke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.ananke.model.Order_items;
import it.beije.ananke.model.User;

@Repository
public interface Order_itemsRepository extends JpaRepository <Order_items, Integer> {

}