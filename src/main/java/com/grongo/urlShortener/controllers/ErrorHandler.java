package com.grongo.urlShortener.controllers;


import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {


    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public String notFound(ChangeSetPersister.NotFoundException e){
        return e.getMessage();
    }

}
