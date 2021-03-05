package it.beije.ananke.ecommerce.beans;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private List<OrderItem> items= new ArrayList<OrderItem>();
	
	private Double amount = 0.0;
	
	public List<OrderItem> getItems(){
		return items;
	}
	
	public void setItems(OrderItem item) {
		
		for (OrderItem orderItem : items) {
			if(orderItem.getProductId().equals(item.getProductId())) {
				orderItem.setQuantity(orderItem.getQuantity() + item.getQuantity());
				orderItem.setAmount(orderItem.getAmount() + item.getAmount());
				amount = amount + item.getAmount();
				return;
			}
		}
		
		amount = amount + item.getAmount();
		
		items.add(item);
		
	}
	
	public void removeItem(OrderItem item) {
		
		int index = -1;
		boolean empty = false;
		
		for (OrderItem orderItem : items) {
			
			if(orderItem.getProductId().equals(item.getProductId())) {
				
				index = items.indexOf(orderItem);
				orderItem.setQuantity(orderItem.getQuantity() - item.getQuantity());
				orderItem.setAmount(orderItem.getAmount() - item.getAmount());
				if(orderItem.getQuantity().equals(0))
					empty = true;
				
			}
			
		}
		
		if(index >= 0) {
			
			amount = amount - item.getAmount();
			
			if(empty)
				items.remove(index);	
			
		}
		
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
