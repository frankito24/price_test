package com.example.price_test.infrastructure.mapper;

import com.example.dto.PriceDto;
import com.example.price_test.domain.model.Price;
import com.example.price_test.infrastructure.entity.PriceEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PriceMapperTest {

    private final PriceMapper priceMapper = PriceMapper.INSTANCE;

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

    @Test
    public void testToDto() {
        Price price = new Price();
        price.setId(1);
        price.setCurrency("USD");
        price.setStartDate(LocalDateTime.of(2023, 1, 1, 0, 0));
        price.setEndDate(LocalDateTime.of(2023, 12, 31, 23, 59));

        PriceDto priceDto = priceMapper.toDto(price);

        assertNotNull(priceDto);
        assertEquals(1, priceDto.getPriceList());
        assertEquals("USD", priceDto.getCurr());
        assertEquals(OffsetDateTime.parse("2023-01-01T00:00:00Z"), priceDto.getStartDate());
        assertEquals(OffsetDateTime.parse("2023-12-31T23:59:00Z"), priceDto.getEndDate());
    }

    @Test
    public void testLocalDateTimeToOffsetDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2023, 1, 1, 0, 0);
        OffsetDateTime offsetDateTime = priceMapper.LocalDateTimeToOffsetDateTime(localDateTime);

        assertNotNull(offsetDateTime);
        assertEquals(OffsetDateTime.parse("2023-01-01T00:00:00Z"), offsetDateTime);
    }
}