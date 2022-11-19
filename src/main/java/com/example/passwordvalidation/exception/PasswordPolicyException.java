package com.example.passwordvalidation.exception;

public class PasswordPolicyException extends Throwable {
	
	private int code;
	private String errorMessage;
	
	public PasswordPolicyException() {
		super();
	}

	public PasswordPolicyException(int code, String errorMessage) {
		super();
		this.code = code;
		this.errorMessage = errorMessage;
	}

	
}
