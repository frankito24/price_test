package com.example.price_test.infrastructure.repository;

import com.example.price_test.infrastructure.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepositoryJpa extends JpaRepository<PriceEntity, Integer> {

    List<PriceEntity> getByProductIdAndBrandId(Integer productId, Integer brandId);
}
