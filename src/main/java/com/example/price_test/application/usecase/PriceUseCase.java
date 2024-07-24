package com.example.price_test.application.usecase;

import com.example.price_test.domain.exception.NotFoundPriceCriteria;
import com.example.price_test.domain.model.Price;
import com.example.price_test.domain.repository.PriceRepository;
import com.example.price_test.domain.service.PriceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceUseCase implements PriceService {
    private final PriceRepository priceRepository;

    public PriceUseCase(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Optional<Price> findApplicablePrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        return Optional.ofNullable(priceRepository.findApplicablePrice(applicationDate, productId, brandId)
                .orElseThrow(NotFoundPriceCriteria::new));
    }
}
