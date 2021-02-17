package ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import ecommerce.entity.*;

import ecommerce.repository.Order_ItemRepository;

@Service
public class Order_ItemService {

	@Autowired
	private Order_ItemRepository order_item_rep;
	
	public void addOrder_Item(Integer id,Cart cart) {
		for(Cart_Item ci : cart.getItems()) {
			order_item_rep.save(ci.getOrder_Item(id));
		}
	}
	
	public List<Order_Item> findAll(){
		return order_item_rep.findAll();
	}
	
	public List<Order_Item> findAllById(Integer id){
		List<Order_Item> all = findAll();
		List<Order_Item> order_items = new ArrayList<>();
		for(Order_Item oi : all) {
			if(oi.getOrder_id() == id) {
				order_items.add(oi);
			}
		}
		return order_items;
	}

	public Order_Item getOne(Integer id) {
		return order_item_rep.getOne(id);
	}

	public void delete(Order_Item o) {
		order_item_rep.delete(o);
	}
	
	
	

	
}
