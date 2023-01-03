package com.sebastian.homepage.api.domain.core.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler {


    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ErrorMessage handleThis(NotFoundException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                new Date(),
                exception.getMessage(),
                request.getDescription(false));
        return message;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ErrorMessage handleMethodArgumentNotValid(ConstraintViolationException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return message;
    }
}
