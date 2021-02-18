package it.beije.ananke.model;

public class CartItem {
	
	private Product product;
	private int quantity;
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public OrderItem getOrder_Item(int orderId) {
		OrderItem orderItem = new OrderItem();
		orderItem.setAmount(product.getPrice() * quantity);
		orderItem.setProductId(product.getId());
		orderItem.setOrderId(orderId);
		orderItem.setQuantity(quantity);
		return orderItem;
	}
}
