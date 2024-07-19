package com.example.price_test.domain.service;

import com.example.price_test.BaseTest;
import com.example.price_test.domain.exception.NotFoundPriceCriteria;
import com.example.price_test.domain.model.Price;
import com.example.price_test.domain.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PriceServiceTest extends BaseTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceService priceService;

     @Test
    public void testFindApplicablePrice_whenPriceIsFound() {
        LocalDateTime applicationDate = LocalDateTime.now();
        Integer productId = 1;
        Integer brandId = 1;

        Price price1 = new Price();
        price1.setStartDate(applicationDate.minusDays(1));
        price1.setEndDate(applicationDate.plusDays(1));
        price1.setPriority(1);

        Price price2 = new Price();
        price2.setStartDate(applicationDate.minusDays(1));
        price2.setEndDate(applicationDate.plusDays(1));
        price2.setPriority(2);

        List<Price> prices = Arrays.asList(price1, price2);

        when(priceRepository.findPriceByProductIdAndBrandId(productId, brandId)).thenReturn(prices);

        Optional<Price> actualPrice = priceService.findApplicablePrice(applicationDate, productId, brandId);

        assertTrue(actualPrice.isPresent());
        assertEquals(price2, actualPrice.get());
        verify(priceRepository).findPriceByProductIdAndBrandId(productId, brandId);
    }

    @Test
    public void testFindApplicablePrice_whenPriceIsNotFound() {
        LocalDateTime applicationDate = LocalDateTime.now();
        Integer productId = 1;
        Integer brandId = 1;

        when(priceRepository.findPriceByProductIdAndBrandId(productId, brandId)).thenReturn(List.of());

        NotFoundPriceCriteria exception = assertThrows(NotFoundPriceCriteria.class, () -> priceService.findApplicablePrice(applicationDate, productId, brandId));

        assertEquals("error.not_found_price_criteria", exception.getMessage());
        verify(priceRepository).findPriceByProductIdAndBrandId(productId, brandId);
    }

    @Test
    public void testFindApplicablePrice_withNonMatchingDates() {
        LocalDateTime applicationDate = LocalDateTime.now();
        Integer productId = 1;
        Integer brandId = 1;

        Price price1 = new Price();
        price1.setStartDate(applicationDate.minusDays(2));
        price1.setEndDate(applicationDate.minusDays(1));

        Price price2 = new Price();
        price2.setStartDate(applicationDate.plusDays(1));
        price2.setEndDate(applicationDate.plusDays(2));

        List<Price> prices = Arrays.asList(price1, price2);

        when(priceRepository.findPriceByProductIdAndBrandId(productId, brandId)).thenReturn(prices);

        NotFoundPriceCriteria exception = assertThrows(NotFoundPriceCriteria.class, () -> priceService.findApplicablePrice(applicationDate, productId, brandId));

        assertEquals("error.not_found_price_criteria", exception.getMessage());
        verify(priceRepository).findPriceByProductIdAndBrandId(productId, brandId);
    }
}