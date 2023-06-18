package com.dxc.project.exception;

public class UserNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String msg) {
		super(msg);
		
	}
	

}
