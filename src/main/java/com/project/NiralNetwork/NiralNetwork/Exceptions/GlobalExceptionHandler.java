package com.project.NiralNetwork.NiralNetwork.Exceptions;

import com.project.NiralNetwork.NiralNetwork.DTOs.ApiResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    //handler resource not found
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ApiResponseMessage> EmployeeNotFoundExceptionHandler(EmployeeNotFoundException ex) {
        logger.info("Exception Handler invoked !!");
        ApiResponseMessage response = ApiResponseMessage.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);

    }
}
