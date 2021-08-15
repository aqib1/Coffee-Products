package com.accenture.io.exceptions;

public class SizeUnavailableException extends RuntimeException {

    public SizeUnavailableException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public SizeUnavailableException(String message) {
        super(message);
    }
}
