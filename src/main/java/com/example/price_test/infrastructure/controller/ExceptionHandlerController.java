package com.example.price_test.infrastructure.controller;

import com.example.dto.ErrorDto;
import com.example.price_test.domain.exception.NotFoundPriceCriteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NotFoundPriceCriteria.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(NotFoundPriceCriteria ex) {
        ErrorDto errorDetails = new ErrorDto();
        errorDetails.setCode(ex.getMessage());
        errorDetails.setMessage("The specified price criteria could not be found.");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
