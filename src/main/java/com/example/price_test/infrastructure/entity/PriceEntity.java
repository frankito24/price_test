package com.example.price_test.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "PRICE")
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prices_id_seq")
    @SequenceGenerator(name = "prices_id_seq", sequenceName = "prices_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "price_list")
    private Integer priceList;

    private Integer priority;

    private Double price;

    private String curr;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;
}
