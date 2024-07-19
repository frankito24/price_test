package com.example.price_test.infrastructure.repository;

import com.example.price_test.infrastructure.entity.PriceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PriceRepositoryJpaTest {

    @Autowired
    private PriceRepositoryJpa priceRepositoryJpa;

    @Test
    public void testGetByProductIdAndBrandId() {
        List<PriceEntity> prices = priceRepositoryJpa.getByProductIdAndBrandId(35455, 1);

        assertNotNull(prices);
        assertEquals(4, prices.size());
    }
}