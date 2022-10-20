package com.javaguides.firstproject.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class NotAuthorizedException extends RuntimeException {
    public NotAuthorizedException(String s) {
        super("UNAUTHORIZED : " + s);
    }
}
