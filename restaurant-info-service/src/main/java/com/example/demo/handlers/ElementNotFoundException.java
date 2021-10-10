package com.example.demo.handlers;

public class ElementNotFoundException extends RuntimeException {

	private String message;

	public ElementNotFoundException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "ERR-1010-"+message;
	}
	
	
	
	
}
