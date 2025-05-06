package com.app.product.exceptions;

public class DuplicateKeyException extends RuntimeException{

    public DuplicateKeyException(){}

    public DuplicateKeyException(String message){
        super(message);
    }

    public DuplicateKeyException(Throwable tw){
        super(tw);
    }

    public DuplicateKeyException(String message, Throwable tw){
        super(message, tw);
    }
}
