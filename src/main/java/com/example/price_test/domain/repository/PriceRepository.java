package com.example.price_test.domain.repository;

import com.example.price_test.domain.model.Price;

import java.util.List;

public interface PriceRepository {

    List<Price> findPriceByProductIdAndBrandId(Integer productId, Integer brandId);
}
