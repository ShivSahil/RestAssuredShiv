package com.bookapi.pojo.response;

public class Message {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public String toString() {
	    return "{\n" +
	           "  \"message\": \"" + message + "\"\n" +
	           "}";
	}

}
