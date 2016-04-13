package com.importsource.rpc.common.excpetion;

public class RegisterException extends RuntimeException {
	private static final long serialVersionUID = 8630858492582467154L;

	public RegisterException() {
		super();
	}

	public RegisterException(String message) {
		super(message);
	}
}
