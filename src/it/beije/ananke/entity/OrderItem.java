package it.beije.ananke.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "order_id")
	private int order_id;
	
	@Column(name = "product_id")
	private int product_id;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "amount")
	private double amount;
	
	
	public OrderItem() {
		
	}

	public OrderItem(int order_id, int product_id, int quantity, double amount) {
		this.order_id = order_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.amount = amount;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	
	
}
