package it.beije.ananke.model;

import java.util.List;

public class Cart {
	private Order order;
	private User user;
	private List<CartItem> list;
	
	
	public Order getOrder() {
		return order;
	}
	
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	public User getUser() {
		return user;
	}
	
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public List<CartItem> getList() {
		return list;
	}
	
	
	public void setList(List<CartItem> list) {
		this.list = list;
	}
	
}
