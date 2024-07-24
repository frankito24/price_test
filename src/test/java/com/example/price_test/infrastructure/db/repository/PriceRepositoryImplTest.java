package com.example.price_test.infrastructure.db.repository;

import com.example.price_test.BaseTest;
import com.example.price_test.domain.model.Price;
import com.example.price_test.infrastructure.db.entity.PriceEntity;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PriceRepositoryImplTest extends BaseTest {
    @Mock
    private PriceRepositoryJpa priceRepositoryJpa;

    @InjectMocks
    private PriceRepositoryImpl priceRepositoryImpl;

    @Test
    public void testFindPriceByProductIdAndBrandId() {
        // Given
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setId(1);
        priceEntity.setProductId(1);
        priceEntity.setBrandId(1);
        priceEntity.setPrice(100.0);
        priceEntity.setStartDate(LocalDateTime.now().minusDays(10));
        priceEntity.setEndDate(LocalDateTime.now().plusDays(10));
        priceEntity.setPriority(1);

        Optional<PriceEntity> priceEntities = Optional.of(priceEntity);

        LocalDateTime now = LocalDateTime.now();

        when(priceRepositoryJpa.findApplicablePrice(now, 1, 1)).thenReturn(priceEntities);

        Optional<Price> price = priceRepositoryImpl.findApplicablePrice(now, 1, 1);

        assertTrue(price.isPresent());
        assertEquals(priceEntity.getPriceList(), price.get().getId());
        assertEquals(priceEntity.getCurr(), price.get().getCurrency());
        assertEquals(priceEntity.getPrice(), price.get().getPrice());
        assertEquals(priceEntity.getStartDate(), price.get().getStartDate());
        assertEquals(priceEntity.getEndDate(), price.get().getEndDate());
        assertEquals(priceEntity.getPriority(), price.get().getPriority());
        assertEquals(priceEntity.getProductId(), price.get().getProductId());
        assertEquals(priceEntity.getBrandId(), price.get().getBrandId());
    }
}