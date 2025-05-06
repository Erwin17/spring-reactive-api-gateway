package com.app.product.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
public class HttpErrorInfo {
    private final ZonedDateTime time;
    private final String path;
    private final HttpStatus httpStatus;
    private final String message;
}
