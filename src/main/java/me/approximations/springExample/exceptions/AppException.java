package me.approximations.springExample.exceptions;

import org.springframework.http.HttpStatus;

public abstract class AppException extends RuntimeException {
    public AppException(String msg) {
        super(msg);
    }

    public abstract HttpStatus getStatus();
}
