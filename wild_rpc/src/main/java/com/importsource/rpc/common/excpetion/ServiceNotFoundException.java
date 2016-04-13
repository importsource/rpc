package com.importsource.rpc.common.excpetion;

public class ServiceNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 8630858492582467154L;

	public ServiceNotFoundException() {
		super();
	}

	public ServiceNotFoundException(String message) {
		super(message);
	}
}
