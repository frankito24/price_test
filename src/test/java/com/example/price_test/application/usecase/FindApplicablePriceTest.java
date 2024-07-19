package com.example.price_test.application.usecase;

import com.example.price_test.BaseTest;
import com.example.price_test.domain.exception.NotFoundPriceCriteria;
import com.example.price_test.domain.model.Price;
import com.example.price_test.domain.service.PriceService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FindApplicablePriceTest extends BaseTest {

    @Mock
    private PriceService priceService;

    @InjectMocks
    private FindApplicablePrice findApplicablePrice;

    @Test
    public void testExecute_whenPriceIsFound() {
        LocalDateTime applicationDate = LocalDateTime.now();
        Integer productId = 1;
        Integer brandId = 1;
        Price expectedPrice = new Price();
        expectedPrice.setProductId(productId);
        expectedPrice.setBrandId(brandId);

        when(priceService.findApplicablePrice(applicationDate, productId, brandId)).thenReturn(Optional.of(expectedPrice));

        Optional<Price> actualPrice = findApplicablePrice.execute(applicationDate, productId, brandId);

        assertEquals(Optional.of(expectedPrice), actualPrice);
        verify(priceService).findApplicablePrice(applicationDate, productId, brandId);
    }

    @Test
    public void testExecute_whenPriceIsNotFound() {
        LocalDateTime applicationDate = LocalDateTime.now();
        Integer productId = 1;
        Integer brandId = 1;

        when(priceService.findApplicablePrice(applicationDate, productId, brandId)).thenThrow(new NotFoundPriceCriteria());

        NotFoundPriceCriteria exception = assertThrows(NotFoundPriceCriteria.class, () -> findApplicablePrice.execute(applicationDate, productId, brandId));

        assertInstanceOf(NotFoundPriceCriteria.class, exception);
        assertEquals("error.not_found_price_criteria", exception.getMessage());

        verify(priceService).findApplicablePrice(applicationDate, productId, brandId);
    }

}