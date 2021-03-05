package it.beije.ananke.ecommerce;

public class CartItem {
	
	private int orderItemId;
	
	private String name;
	
	private double amount;
	
	private int quantity;

	
	
	public int getOrderItemId() {
		return orderItemId;
	}


	public void setOrderItemId(int id) {
		this.orderItemId = id;
	}


	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public double getAmount() {
		return amount;
	}

	
	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	public int getQuantity() {
		return quantity;
	}

	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
