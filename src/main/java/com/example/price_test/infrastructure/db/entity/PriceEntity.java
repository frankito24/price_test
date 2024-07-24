package com.example.price_test.infrastructure.db.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "PRICE")
public class PriceEntity {

    public PriceEntity( Integer id, Integer brandId, Integer productId, Integer priceList, Integer priority, Double price, String curr, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.brandId = brandId;
        this.productId = productId;
        this.priceList = priceList;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public PriceEntity() {
    }

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
