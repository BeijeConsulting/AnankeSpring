package it.beije.ananke.ecommerce.dto;

import it.beije.ananke.ecommerce.beans.Orders;

public class OrderMessage {
	
	private Orders order;
	
	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message;

}
