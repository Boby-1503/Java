package com.example.ECommerce.Ecommerce.Exceptions;

public class CustomerValidationException extends RuntimeException {
    public CustomerValidationException(String message) {
        super(message);
    }
}

