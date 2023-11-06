package com.example.ECommerce.Ecommerce.Exceptions;

public class ProductValidationException extends RuntimeException{
    public ProductValidationException(String message){
        super(message);
    }
}
