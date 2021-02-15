package ecommerce.entity;
import javax.persistence.*;



@Entity
@Table(name="order_item")

public class Order_Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int id;
	
	@Column(name="id_order", nullable = false)
	private int order_id;
	
	@Column(name="id_product", nullable = false)
	
	private int product_id;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="amount")
	private double amount;

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
