package com.example.price_test.application.usecase;

import com.example.price_test.domain.model.Price;
import com.example.price_test.domain.service.PriceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FindApplicablePrice {
    private final PriceService priceService;

    public FindApplicablePrice(PriceService priceService) {
        this.priceService = priceService;
    }

    public Optional<Price> execute(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return priceService.findApplicablePrice(applicationDate, productId, brandId);
    }
}
