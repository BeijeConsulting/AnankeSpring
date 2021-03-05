package it.beije.ananke.ecommerce.dto;

import java.util.List;

import it.beije.ananke.ecommerce.beans.Product;

public class HomeMessage {

	private List<Product> products;
	
	private String message;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
