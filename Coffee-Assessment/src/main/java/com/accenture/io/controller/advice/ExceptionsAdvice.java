package com.accenture.io.controller.advice;


import com.accenture.io.controller.model.ResponseError;
import com.accenture.io.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Optional;

@RestControllerAdvice
public class ExceptionsAdvice {
    @ExceptionHandler(value
            = {RuntimeException.class, IllegalStateException.class})
    public ResponseEntity<ResponseError> handleRuntimeException(
            RuntimeException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Internal server exception! => (RuntimeException)]";
        ResponseError errorResponse =  ResponseError.builder().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(RuntimeException.class.getName()).errorMessage(e.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = FileHelperException.class)
    public ResponseEntity<ResponseError> handleFileHelperException(
            FileHelperException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Internal server exception! => (FileHelperException)]";
        ResponseError errorResponse =  ResponseError.builder().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .exceptionName(FileHelperException.class.getName()).errorMessage(e.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = OrderNotFoundException.class)
    public ResponseEntity<ResponseError> handleOrderNotFoundException(
            OrderNotFoundException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Bad request exception! => (OrderNotFoundException)]";
        ResponseError errorResponse =  ResponseError.builder().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.BAD_REQUEST.value())
                .exceptionName(OrderNotFoundException.class.getName()).errorMessage(e.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = PaymentNotFoundException.class)
    public ResponseEntity<ResponseError> handlePaymentNotFoundException(
            PaymentNotFoundException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Bad request exception! => (PaymentNotFoundException)]";
        ResponseError errorResponse =  ResponseError.builder().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.BAD_REQUEST.value())
                .exceptionName(PaymentNotFoundException.class.getName()).errorMessage(e.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<ResponseError> handleProductNotFoundException(
            ProductNotFoundException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Bad request exception! => (ProductNotFoundException)]";
        ResponseError errorResponse =  ResponseError.builder().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.BAD_REQUEST.value())
                .exceptionName(ProductNotFoundException.class.getName()).errorMessage(e.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = SizeUnavailableException.class)
    public ResponseEntity<ResponseError> handleSizeUnavailableException(
            SizeUnavailableException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Bad request exception! => (SizeUnavailableException)]";
        ResponseError errorResponse =  ResponseError.builder().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.BAD_REQUEST.value())
                .exceptionName(SizeUnavailableException.class.getName()).errorMessage(e.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<ResponseError> handleValidationException(
            ValidationException e, WebRequest request) {
        String error = Optional.of(e.getMessage()).orElse(e.getClass().getName())
                + " [Bad request exception! => (ValidationException)]";
        ResponseError errorResponse =  ResponseError.builder().createdAt(LocalDateTime.now().toString())
                .detailedMessage(error).errorCode(HttpStatus.BAD_REQUEST.value())
                .exceptionName(ValidationException.class.getName()).errorMessage(e.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
