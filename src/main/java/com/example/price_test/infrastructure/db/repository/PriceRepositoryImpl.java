package com.example.price_test.infrastructure.db.repository;

import com.example.price_test.domain.model.Price;
import com.example.price_test.domain.repository.PriceRepository;
import com.example.price_test.infrastructure.db.entity.PriceEntity;
import com.example.price_test.infrastructure.db.mapper.PriceDbMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PriceRepositoryImpl implements PriceRepository {
    private final PriceRepositoryJpa priceRepositoryJpa;

    public PriceRepositoryImpl(PriceRepositoryJpa priceRepositoryJpa) {
        this.priceRepositoryJpa = priceRepositoryJpa;
    }

    @Override
    public Optional<Price> findApplicablePrice(LocalDateTime applicationDate, Integer productId, Integer brandId) {
        Optional<PriceEntity> priceEntity = priceRepositoryJpa.findApplicablePrice(applicationDate, productId, brandId);

        return priceEntity.map(PriceDbMapper.INSTANCE::toModel);
    }
}
