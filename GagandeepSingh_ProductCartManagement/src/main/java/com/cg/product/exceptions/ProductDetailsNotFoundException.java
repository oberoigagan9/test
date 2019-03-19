package com.cg.product.exceptions;

public class ProductDetailsNotFoundException extends Exception { //details not found

	public ProductDetailsNotFoundException() {
		super();

	}
	public ProductDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public ProductDetailsNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	public ProductDetailsNotFoundException(String message) {
		super(message);
	}
	public ProductDetailsNotFoundException(Throwable cause) {
		super(cause);
	}
}

