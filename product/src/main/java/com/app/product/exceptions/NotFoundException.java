package com.app.product.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(){}

    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(Throwable tw){
        super(tw);
    }

    public NotFoundException(String message, Throwable tw){
        super(message, tw);
    }
}
