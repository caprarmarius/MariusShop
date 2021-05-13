package com.mariushop.mariushop.exceptions;

public class ProductsNotAvailableException extends RuntimeException {

    public ProductsNotAvailableException(String message) {
        super(message);
    }
}

