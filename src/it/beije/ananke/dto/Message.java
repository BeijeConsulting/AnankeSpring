package it.beije.ananke.dto;

public class Message {
	
	private static String message;
	
	public Message(String message) {
		Message.message = message;
	}

	public static String getMessage() {
		return message;
	}

	public static void setMessage(String message) {
		Message.message = message;
	}

}
