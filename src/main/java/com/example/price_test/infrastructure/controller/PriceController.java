package com.example.price_test.infrastructure.controller;

import com.example.api.PriceApi;
import com.example.dto.PriceDto;
import com.example.price_test.application.usecase.FindApplicablePrice;
import com.example.price_test.infrastructure.mapper.PriceMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api/v1")
public class PriceController implements PriceApi {

    private final FindApplicablePrice findApplicablePrice;

    public PriceController(FindApplicablePrice findApplicablePrice) {
        this.findApplicablePrice = findApplicablePrice;
    }

    @Override
    public ResponseEntity<PriceDto> getPrice(OffsetDateTime applicationDate, Integer productId, Integer brandId) {
        return findApplicablePrice.execute(applicationDate.toLocalDateTime(), productId, brandId)
                .map(PriceMapper.INSTANCE::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
