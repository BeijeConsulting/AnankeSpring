package it.beije.ananke.ecommerce.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.*;
import java.util.Set;

@JsonInclude(Include.NON_NULL)
@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="amount")
	private Double amount;
	
	@Column(name="state")
	private String state;

	@OneToMany(mappedBy = "orderId", fetch = FetchType.EAGER)
	private Set<OrderItem> itemSet;

	public Set<OrderItem> getItemSet() {
		return itemSet;
	}

	public void setItemSet(Set<OrderItem> itemSet) {
		this.itemSet = itemSet;
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
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
}
