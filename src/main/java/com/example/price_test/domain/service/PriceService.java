package com.example.price_test.domain.service;

import com.example.price_test.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceService {

    Optional<Price> findApplicablePrice(LocalDateTime applicationDate, Integer productId, Integer brandId);
}
