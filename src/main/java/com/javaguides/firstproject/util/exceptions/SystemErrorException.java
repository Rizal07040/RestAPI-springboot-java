package com.javaguides.firstproject.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SystemErrorException extends RuntimeException {
    public SystemErrorException() {
        super("Ada kesalahan, Mohon lapor ke admin");
    }
}
