package com.example.price_test.domain.exception;

public class NotFoundPriceCriteria extends RuntimeException {

    public NotFoundPriceCriteria() {
        super("error.not_found_price_criteria");
    }
}
