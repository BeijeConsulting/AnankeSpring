package it.beije.ananke.ecommerce.dto;

import it.beije.ananke.ecommerce.beans.User;

public class LogInMessage {

	private User user;
	
	private String message;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
