package com.example.price_test.infrastructure.repository;

import com.example.price_test.domain.model.Price;
import com.example.price_test.domain.repository.PriceRepository;
import com.example.price_test.infrastructure.entity.PriceEntity;
import com.example.price_test.infrastructure.mapper.PriceMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceRepositoryImpl implements PriceRepository {
    private final PriceRepositoryJpa priceRepositoryJpa;

    public PriceRepositoryImpl(PriceRepositoryJpa priceRepositoryJpa) {
        this.priceRepositoryJpa = priceRepositoryJpa;
    }

    @Override
    public List<Price> findPriceByProductIdAndBrandId(Integer productId, Integer brandId) {
        List<PriceEntity> priceEntities = priceRepositoryJpa.getByProductIdAndBrandId(productId, brandId);

        return priceEntities.stream().map(PriceMapper.INSTANCE::toModel).toList();
    }
}
