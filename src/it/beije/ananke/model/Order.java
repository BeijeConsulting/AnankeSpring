package it.beije.ananke.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="order")
public class Order {
 
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="state")
	String state;
	
	public Order(Integer id, Integer userId, double amount, String state) {
		super();
		this.id = id;
		this.userId = userId;
		this.amount = amount;
		this.state = state;
	}
	public Order() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", amount=" + amount + ", state=" + state + "]";
	}
	
}
