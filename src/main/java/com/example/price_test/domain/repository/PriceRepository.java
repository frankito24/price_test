package com.example.price_test.domain.repository;

import com.example.price_test.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository {

    Optional<Price> findApplicablePrice(LocalDateTime applicationDate, Integer productId, Integer brandId);
}
