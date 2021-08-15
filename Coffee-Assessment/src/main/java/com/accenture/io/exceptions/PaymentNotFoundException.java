package com.accenture.io.exceptions;

public class PaymentNotFoundException extends RuntimeException {

    public PaymentNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public PaymentNotFoundException(String message) {
        super(message);
    }
}
