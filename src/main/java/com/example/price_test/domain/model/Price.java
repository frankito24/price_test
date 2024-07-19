package com.example.price_test.domain.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Price {

    private Integer id;

    private Integer brandId;

    private Integer productId;

    private Integer priority;

    private Double price;

    private String currency;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
