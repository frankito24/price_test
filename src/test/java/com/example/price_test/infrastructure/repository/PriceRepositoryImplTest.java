package com.example.price_test.infrastructure.repository;

import com.example.price_test.BaseTest;
import com.example.price_test.domain.model.Price;
import com.example.price_test.infrastructure.entity.PriceEntity;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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
        PriceEntity priceEntity1 = new PriceEntity();
        priceEntity1.setId(1);
        priceEntity1.setProductId(1);
        priceEntity1.setBrandId(1);
        priceEntity1.setPrice(100.0);
        priceEntity1.setStartDate(LocalDateTime.now().minusDays(10));
        priceEntity1.setEndDate(LocalDateTime.now().plusDays(10));
        priceEntity1.setPriority(1);

        PriceEntity priceEntity2 = new PriceEntity();
        priceEntity2.setId(2);
        priceEntity2.setProductId(1);
        priceEntity2.setBrandId(1);
        priceEntity2.setPrice(200.0);
        priceEntity2.setStartDate(LocalDateTime.now().minusDays(10));
        priceEntity2.setEndDate(LocalDateTime.now().plusDays(10));
        priceEntity2.setPriority(2);

        List<PriceEntity> priceEntities = Arrays.asList(priceEntity1, priceEntity2);

        when(priceRepositoryJpa.getByProductIdAndBrandId(1, 1)).thenReturn(priceEntities);

        List<Price> prices = priceRepositoryImpl.findPriceByProductIdAndBrandId(1, 1);

        assertEquals(2, prices.size());
    }
}