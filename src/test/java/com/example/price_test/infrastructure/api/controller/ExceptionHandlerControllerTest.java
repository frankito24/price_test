package com.example.price_test.infrastructure.api.controller;

import com.api.generated.dto.ErrorDto;
import com.example.price_test.domain.exception.NotFoundPriceCriteria;
import com.example.price_test.infrastructure.api.handler.ExceptionHandlerController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ExceptionHandlerControllerTest {

    @InjectMocks
    private ExceptionHandlerController exceptionHandlerController;

    @BeforeEach
    public void setUp() {
        exceptionHandlerController = new ExceptionHandlerController();
    }

    @Test
    public void testHandleResourceNotFoundException() {
        NotFoundPriceCriteria exception = new NotFoundPriceCriteria();
        mock(WebRequest.class);

        ResponseEntity<ErrorDto> responseEntity = exceptionHandlerController.handleResourceNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals("error.not_found_price_criteria", responseEntity.getBody().getCode());
        assertEquals("The specified price criteria could not be found.", responseEntity.getBody().getMessage());
    }
}