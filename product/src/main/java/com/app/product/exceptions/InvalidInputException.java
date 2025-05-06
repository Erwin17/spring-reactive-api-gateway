package com.app.product.exceptions;

public class InvalidInputException extends RuntimeException{

    public InvalidInputException(){}

    public InvalidInputException(String message){
        super(message);
    }

    public InvalidInputException(Throwable tw){
        super(tw);
    }

    public InvalidInputException(String message, Throwable tw){
        super(message, tw);
    }
}
