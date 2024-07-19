package com.example.price_test.infrastructure.controller;

import com.example.dto.PriceDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PriceControllerTest {
     @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFailFindApplicablePrice() throws Exception {
        int productId = 35455;
        int brandId = 1;

        mockMvc.perform(get("/api/v1/price")
                        .param("applicationDate", "2024-06-14T10:00:00.000Z")
                        .param("productId", String.valueOf(productId))
                        .param("brandId", String.valueOf(brandId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void test1FindApplicablePrice() throws Exception {
        int productId = 35455;
        int brandId = 1;

        MvcResult result = mockMvc.perform(get("/api/v1/price")
                        .param("applicationDate", "2020-06-14T10:00:00.000Z")
                        .param("productId", String.valueOf(productId))
                        .param("brandId", String.valueOf(brandId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        PriceDto responsePrice = objectMapper.readValue(responseBody, PriceDto.class);

        assertEquals(0, responsePrice.getPriority());
        assertEquals(productId, responsePrice.getProductId());
        assertEquals(brandId, responsePrice.getBrandId());
        assertEquals(OffsetDateTime.of(2020, 6, 14, 0, 0, 0, 0, ZoneOffset.UTC), responsePrice.getStartDate());
        assertEquals(OffsetDateTime.of(2020, 12, 31, 23, 59, 59, 0, ZoneOffset.UTC), responsePrice.getEndDate());
        assertEquals(1, responsePrice.getPriceList());
        assertEquals(35.5, responsePrice.getPrice());
        assertEquals("EUR", responsePrice.getCurr());
    }

    @Test
    public void test2FindApplicablePrice() throws Exception {
        int productId = 35455;
        int brandId = 1;

        MvcResult result = mockMvc.perform(get("/api/v1/price")
                        .param("applicationDate", "2020-06-14T16:00:00.000Z")
                        .param("productId", String.valueOf(productId))
                        .param("brandId", String.valueOf(brandId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        PriceDto responsePrice = objectMapper.readValue(responseBody, PriceDto.class);

        assertEquals(1, responsePrice.getPriority());
        assertEquals(productId, responsePrice.getProductId());
        assertEquals(brandId, responsePrice.getBrandId());
        assertEquals(OffsetDateTime.of(2020, 6, 14, 15, 0, 0, 0, ZoneOffset.UTC), responsePrice.getStartDate());
        assertEquals(OffsetDateTime.of(2020, 6, 14, 18, 30, 0, 0, ZoneOffset.UTC), responsePrice.getEndDate());
        assertEquals(2, responsePrice.getPriceList());
        assertEquals(25.45, responsePrice.getPrice());
        assertEquals("EUR", responsePrice.getCurr());
    }

    @Test
    public void test3FindApplicablePrice() throws Exception {
        int productId = 35455;
        int brandId = 1;

        MvcResult result = mockMvc.perform(get("/api/v1/price")
                        .param("applicationDate", "2020-06-14T21:00:00.000Z")
                        .param("productId", String.valueOf(productId))
                        .param("brandId", String.valueOf(brandId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        PriceDto responsePrice = objectMapper.readValue(responseBody, PriceDto.class);

        assertEquals(0, responsePrice.getPriority());
        assertEquals(productId, responsePrice.getProductId());
        assertEquals(brandId, responsePrice.getBrandId());
        assertEquals(OffsetDateTime.of(2020, 6, 14, 0, 0, 0, 0, ZoneOffset.UTC), responsePrice.getStartDate());
        assertEquals(OffsetDateTime.of(2020, 12, 31, 23, 59, 59, 0, ZoneOffset.UTC), responsePrice.getEndDate());
        assertEquals(1, responsePrice.getPriceList());
        assertEquals(35.5, responsePrice.getPrice());
        assertEquals("EUR", responsePrice.getCurr());
    }

    @Test
    public void test4FindApplicablePrice() throws Exception {
        int productId = 35455;
        int brandId = 1;

        MvcResult result = mockMvc.perform(get("/api/v1/price")
                        .param("applicationDate", "2020-06-15T10:00:00.000Z")
                        .param("productId", String.valueOf(productId))
                        .param("brandId", String.valueOf(brandId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        PriceDto responsePrice = objectMapper.readValue(responseBody, PriceDto.class);

        assertEquals(1, responsePrice.getPriority());
        assertEquals(productId, responsePrice.getProductId());
        assertEquals(brandId, responsePrice.getBrandId());
        assertEquals(OffsetDateTime.of(2020, 6, 15, 0, 0, 0, 0, ZoneOffset.UTC), responsePrice.getStartDate());
        assertEquals(OffsetDateTime.of(2020, 6, 15, 11, 0, 0, 0, ZoneOffset.UTC), responsePrice.getEndDate());
        assertEquals(3, responsePrice.getPriceList());
        assertEquals(30.5, responsePrice.getPrice());
        assertEquals("EUR", responsePrice.getCurr());
    }

    @Test
    public void test5FindApplicablePrice() throws Exception {
        int productId = 35455;
        int brandId = 1;

        MvcResult result = mockMvc.perform(get("/api/v1/price")
                        .param("applicationDate", "2020-06-16T21:00:00.000Z")
                        .param("productId", String.valueOf(productId))
                        .param("brandId", String.valueOf(brandId))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        PriceDto responsePrice = objectMapper.readValue(responseBody, PriceDto.class);

        assertEquals(1, responsePrice.getPriority());
        assertEquals(productId, responsePrice.getProductId());
        assertEquals(brandId, responsePrice.getBrandId());
        assertEquals(OffsetDateTime.of(2020, 6, 15, 16, 0, 0, 0, ZoneOffset.UTC), responsePrice.getStartDate());
        assertEquals(OffsetDateTime.of(2020, 12, 31, 23, 59, 59, 0, ZoneOffset.UTC), responsePrice.getEndDate());
        assertEquals(4, responsePrice.getPriceList());
        assertEquals(38.95, responsePrice.getPrice());
        assertEquals("EUR", responsePrice.getCurr());
    }
}