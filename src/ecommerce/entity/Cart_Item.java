package ecommerce.entity;

public class Cart_Item {
	private Product p;
	private int quantity;
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Order_Item getOrder_Item(int order_id) {
		Order_Item oi = new Order_Item();
		oi.setAmount(p.getPrice() * quantity);
		oi.setProduct_id(p.getId());
		oi.setOrder_id(order_id);
		oi.setQuantity(quantity);
		return oi;
	}
}
