package com.sebastian.homepage.api.domain.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
                request.getDescription(false), null);
        return message;
    }

    @ExceptionHandler(value = {FriendlyCaptchaUnavailableException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ErrorMessage handleThis(FriendlyCaptchaUnavailableException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                new Date(),
                exception.getMessage(),
                request.getDescription(false), null);
        return message;
    }

    @ExceptionHandler(value = {MailSendException.class})
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    protected ErrorMessage handleThis(MailSendException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                new Date(),
                exception.getMessage(),
                request.getDescription(false), null);
        return message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected ErrorMessage handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
        BindingResult result = ex.getBindingResult();
        FieldError fieldError = result.getFieldError();
        String rejectedField = fieldError.getField();
        String rejectedValue = fieldError.getRejectedValue().toString();

        ErrorMessage message = new ErrorMessage(
                new Date(),
                ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),
                rejectedField, rejectedValue);
        return message;
    }
}
