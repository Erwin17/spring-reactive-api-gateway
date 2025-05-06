package com.app.product.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class GlobalControllerException {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalControllerException.class);


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public @ResponseBody HttpErrorInfo handleNotFoundException( ServerHttpRequest request,
                                                                NotFoundException ex){
        return createHttpErrorInfo(HttpStatus.NOT_FOUND, request, ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidInputException.class)
    public @ResponseBody HttpErrorInfo invalidInputException(ServerHttpRequest request,
                                              InvalidInputException ex){

        return createHttpErrorInfo(HttpStatus.BAD_REQUEST, request, ex);
    }

    private HttpErrorInfo createHttpErrorInfo(HttpStatus status, ServerHttpRequest request,
                                               Exception ex){
        final String path = request.getPath().pathWithinApplication().value();
        final String message = ex.getMessage();
        LOG.info("Exception  path: {} - message: {}", path, message);
        return new HttpErrorInfo(ZonedDateTime.now(), path, status, message);
    }
}
