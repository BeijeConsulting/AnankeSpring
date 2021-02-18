package it.beije.ananke.model;

import java.util.List;

import it.beije.ananke.model.Product;

public class Cart{
	
	private Integer cartId;
	private Integer userId;
	private List<Product> productList;
	private double  amount;
	
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void addItem(Integer productId, Integer quantity) {
		
		
	}
	
	
	
}
