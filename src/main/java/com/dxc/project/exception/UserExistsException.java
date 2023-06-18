package com.dxc.project.exception;

public class UserExistsException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;

	public UserExistsException() {
		super();
	}

	public UserExistsException(String msg) {
		super(msg);
		
	}
}
