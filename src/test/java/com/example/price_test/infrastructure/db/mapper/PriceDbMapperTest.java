package com.example.price_test.infrastructure.db.mapper;

import com.example.price_test.domain.model.Price;
import com.example.price_test.infrastructure.db.entity.PriceEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceDbMapperTest {

    private final PriceDbMapper priceMapper = PriceDbMapper.INSTANCE;

    @Test
    public void testToModel() {
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setPriceList(1);
        priceEntity.setCurr("USD");

        Price price = priceMapper.toModel(priceEntity);

        assertNotNull(price);
        assertEquals(1, price.getId());
        assertEquals("USD", price.getCurrency());
    }
}