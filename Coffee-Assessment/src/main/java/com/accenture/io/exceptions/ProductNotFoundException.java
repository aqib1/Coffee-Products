package com.accenture.io.exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
