package ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.entity.*;
import ecommerce.entity.Product;

import ecommerce.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository order_rep;
	
	
	public Integer addOrder(User u, Cart cart) {
		Order o = new Order();
		o.setUser_id(u.getId());
		o.setAmount(cart.getAmount());
		o.setState("closed");
		order_rep.save(o);
		return o.getId();
	}
	
	
	
	
	public List<Order> findAll(){
		return order_rep.findAll();
	}
	
	public List<Order> findAllByUserId(Integer id){
		List<Order> allorders = findAll();
		List<Order> ordersOfUser = new ArrayList<>();
		for(Order o: allorders) {
			if(o.getUser_id() == id) {
				ordersOfUser.add(o);
			}
		}
		return ordersOfUser;
	}

	public Order getOne(Integer id) {
		return order_rep.getOne(id);
	}

	public void delete(Order o) {
		order_rep.delete(o);
	}
}
