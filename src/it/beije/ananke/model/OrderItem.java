package it.beije.ananke.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_item")
public class OrderItem {

	 @Id
	 @Column(name="id")
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer id;
	 
	 @Column(name="order_id")
	 private Integer orderId;
	 
	 @Column(name="product_id")
	 private Integer productId;
	 
	 @Column(name="amount")
	 private Integer amount;

	@Column(name="quantity")
	private double quantity;
	

	public OrderItem() {
		super();
	}

	public OrderItem(Integer id, Integer orderId, Integer productId, Integer amount, double quantity) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.amount = amount;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	 @Override
		public String toString() {
			return "OrderItem [id=" + id + ", orderId=" + orderId + ", productId=" + productId + ", amount=" + amount
					+ ", quantity=" + quantity + "]";
		}
}
