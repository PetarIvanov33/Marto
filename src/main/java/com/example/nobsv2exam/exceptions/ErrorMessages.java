package com.example.nobsv2exam.exceptions;

public enum ErrorMessages {
    PRODUCT_NOT_FOUND("Product not found"),
    CATEGORY_NOT_FOUND("Category not found");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
