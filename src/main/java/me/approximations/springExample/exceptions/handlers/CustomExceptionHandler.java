package me.approximations.springExample.exceptions.handlers;

import me.approximations.springExample.error.ApiError;
import me.approximations.springExample.exceptions.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ApiError> handleNotFoundException(AppException exception) {
        return ResponseEntity.status(exception.getStatus()).body(new ApiError(exception.getStatus(), exception.getMessage()));
    }
}
