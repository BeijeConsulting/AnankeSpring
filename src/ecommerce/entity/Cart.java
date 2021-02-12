package ecommerce.entity;

import java.util.*;

import ecommerce.model.JPAManager;


public class Cart{

	private List<Cart_Item> items;
	protected double amount;
	
	public Cart() {
		items = new ArrayList<>();
		amount = 0.0;
	}
	
	public void addItem(int id, int quantity) {
		Product p = JPAManager.getProduct(id);
		if(p!= null) {
		Cart_Item ci = new Cart_Item();
		ci.setP(p);
		ci.setQuantity(quantity);
		items.add(ci);
		amount += p.getPrice() * quantity;
	}
		
		
	}

	public List<Cart_Item> getItems() {
		return items;
	}

	public void setItems(List<Cart_Item> items) {
		this.items = items;
	}
	
	
	
	
}
