package com.example.price_test.domain.service;

import com.example.price_test.domain.exception.NotFoundPriceCriteria;
import com.example.price_test.domain.model.Price;
import com.example.price_test.domain.repository.PriceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public Optional<Price> findApplicablePrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        List<Price> prices = priceRepository.findPriceByProductIdAndBrandId(productId, brandId);

        // El filtro de fecha se implementa en la capa de dominio en vez de la de persistencia,
        // para demostrar la separación de capas en la arquitectura hexagonal.
        return Optional.ofNullable(prices.stream()
                .filter(p -> p.getStartDate().isBefore(applicationDate) && p.getEndDate().isAfter(applicationDate))
                .max(Comparator.comparing(Price::getPriority))
                .orElseThrow(NotFoundPriceCriteria::new));
    }
}
