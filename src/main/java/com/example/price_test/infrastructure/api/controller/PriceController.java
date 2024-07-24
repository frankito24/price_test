package com.example.price_test.infrastructure.api.controller;

import com.api.generated.api.PriceApi;
import com.api.generated.dto.PriceDto;
import com.example.price_test.application.usecase.PriceUseCase;
import com.example.price_test.infrastructure.api.mapper.PriceApiMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api/v1")
public class PriceController implements PriceApi {

    private final PriceUseCase priceUseCase;

    public PriceController(PriceUseCase priceUseCase) {
        this.priceUseCase = priceUseCase;
    }

    @Override
    public ResponseEntity<PriceDto> getPrice(OffsetDateTime applicationDate, Integer productId, Integer brandId) {
        return priceUseCase.findApplicablePrice(applicationDate.toLocalDateTime(), productId, brandId)
                .map(PriceApiMapper.INSTANCE::toDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
