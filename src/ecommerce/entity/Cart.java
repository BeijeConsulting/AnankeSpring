package ecommerce.entity;

import java.lang.System.Logger;
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
			if(!isItem(id, quantity)) {
		Cart_Item ci = new Cart_Item();
		ci.setP(p);
		ci.setQuantity(quantity);
		items.add(ci);
		amount += p.getPrice() * quantity;
			}
	}
		
		
	}

	public List<Cart_Item> getItems() {
		return items;
	}

	public void setItems(List<Cart_Item> items) {
		this.items = items;
	}

	public boolean isItem(int id, int quantity) {
	int index = getItem(id);
	if(index <0) {
		return false;
	}
	int oldquantity = items.get(index).getQuantity();
	items.get(index).setQuantity(oldquantity + quantity);
	this.amount += items.get(index).getP().getPrice() * quantity; 
	return true;
	}
	
	public int getItem(int id) {
		for(Cart_Item ci : this.items) {
	if(ci.getP().getId() == id) {
		return items.indexOf(ci);
	}
	}
		return -1;
	}
	
	
	public void deleteItem(int id) {
		int index = getItem(id);
		Cart_Item ci = this.getItems().remove(index);
		System.out.println(ci.getP().getPrice());
		System.out.println(ci.getQuantity());
		amount -=  (ci.getP().getPrice() * ci.getQuantity());
		
		
		
	}
	public double getAmount() {
		return amount;
	}
	
	
	
	
}
