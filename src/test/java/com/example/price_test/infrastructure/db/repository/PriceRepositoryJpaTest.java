package com.example.price_test.infrastructure.db.repository;

import com.example.price_test.infrastructure.db.entity.PriceEntity;
import com.example.price_test.infrastructure.db.repository.PriceRepositoryJpa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
class PriceRepositoryJpaTest {

    @Autowired
    private PriceRepositoryJpa priceRepositoryJpa;

    @Test
    public void test1FindApplicablePrice() {
        int productId = 35455;
        int brandId = 1;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 14, 10, 0);

        Optional<PriceEntity> foundPrice = priceRepositoryJpa.findApplicablePrice(applicationDate, productId, brandId);

        assertEquals(1, foundPrice.orElseThrow().getBrandId());
        assertEquals(1, foundPrice.orElseThrow().getBrandId());
        assertEquals(LocalDateTime.of(2020, 06, 14, 00, 0), foundPrice.orElseThrow().getStartDate());
        assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59, 59), foundPrice.orElseThrow().getEndDate());
        assertEquals(1, foundPrice.orElseThrow().getPriceList());
        assertEquals(35455, foundPrice.orElseThrow().getProductId());
        assertEquals(0, foundPrice.orElseThrow().getPriority());
        assertEquals(35.5, foundPrice.orElseThrow().getPrice());
        assertEquals("EUR", foundPrice.orElseThrow().getCurr());
    }


    @Test
    public void test2FindApplicablePrice() {
        int productId = 35455;
        int brandId = 1;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 14, 16, 0);

        Optional<PriceEntity> foundPrice = priceRepositoryJpa.findApplicablePrice(applicationDate, productId, brandId);

        assertEquals(1, foundPrice.orElseThrow().getBrandId());
        assertEquals(1, foundPrice.orElseThrow().getBrandId());
        assertEquals(LocalDateTime.of(2020, 06, 14, 15, 0), foundPrice.orElseThrow().getStartDate());
        assertEquals(LocalDateTime.of(2020, 06, 14, 18, 30), foundPrice.orElseThrow().getEndDate());
        assertEquals(2, foundPrice.orElseThrow().getPriceList());
        assertEquals(35455, foundPrice.orElseThrow().getProductId());
        assertEquals(1, foundPrice.orElseThrow().getPriority());
        assertEquals(25.45, foundPrice.orElseThrow().getPrice());
        assertEquals("EUR", foundPrice.orElseThrow().getCurr());
    }


    @Test
    public void test3FindApplicablePrice() {
        int productId = 35455;
        int brandId = 1;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 14, 21, 0);

        Optional<PriceEntity> foundPrice = priceRepositoryJpa.findApplicablePrice(applicationDate, productId, brandId);

        assertEquals(1, foundPrice.orElseThrow().getBrandId());
        assertEquals(1, foundPrice.orElseThrow().getBrandId());
        assertEquals(LocalDateTime.of(2020, 06, 14, 00, 0), foundPrice.orElseThrow().getStartDate());
        assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59, 59), foundPrice.orElseThrow().getEndDate());
        assertEquals(1, foundPrice.orElseThrow().getPriceList());
        assertEquals(35455, foundPrice.orElseThrow().getProductId());
        assertEquals(0, foundPrice.orElseThrow().getPriority());
        assertEquals(35.5, foundPrice.orElseThrow().getPrice());
        assertEquals("EUR", foundPrice.orElseThrow().getCurr());
    }


    @Test
    public void test4FindApplicablePrice() {
        int productId = 35455;
        int brandId = 1;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 15, 10, 0);

        Optional<PriceEntity> foundPrice = priceRepositoryJpa.findApplicablePrice(applicationDate, productId, brandId);

        assertEquals(1, foundPrice.orElseThrow().getBrandId());
        assertEquals(1, foundPrice.orElseThrow().getBrandId());
        assertEquals(LocalDateTime.of(2020, 06, 15, 00, 0), foundPrice.orElseThrow().getStartDate());
        assertEquals(LocalDateTime.of(2020, 06, 15, 11, 00), foundPrice.orElseThrow().getEndDate());
        assertEquals(3, foundPrice.orElseThrow().getPriceList());
        assertEquals(35455, foundPrice.orElseThrow().getProductId());
        assertEquals(1, foundPrice.orElseThrow().getPriority());
        assertEquals(30.5, foundPrice.orElseThrow().getPrice());
        assertEquals("EUR", foundPrice.orElseThrow().getCurr());
    }


    @Test
    public void test5FindApplicablePrice() {
        int productId = 35455;
        int brandId = 1;
        LocalDateTime applicationDate = LocalDateTime.of(2020, 06, 16, 21, 0);

        Optional<PriceEntity> foundPrice = priceRepositoryJpa.findApplicablePrice(applicationDate, productId, brandId);

        assertEquals(1, foundPrice.orElseThrow().getBrandId());
        assertEquals(1, foundPrice.orElseThrow().getBrandId());
        assertEquals(LocalDateTime.of(2020, 06, 15, 16, 0), foundPrice.orElseThrow().getStartDate());
        assertEquals(LocalDateTime.of(2020, 12, 31, 23, 59, 59), foundPrice.orElseThrow().getEndDate());
        assertEquals(4, foundPrice.orElseThrow().getPriceList());
        assertEquals(35455, foundPrice.orElseThrow().getProductId());
        assertEquals(1, foundPrice.orElseThrow().getPriority());
        assertEquals(38.95, foundPrice.orElseThrow().getPrice());
        assertEquals("EUR", foundPrice.orElseThrow().getCurr());
    }
}