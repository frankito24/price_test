package com.example.price_test.infrastructure.db.repository;

import com.example.price_test.infrastructure.db.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceRepositoryJpa extends JpaRepository<PriceEntity, Integer> {


    @Query("SELECT new PriceEntity (p.id, p.brandId, p.productId, p.priceList, p.priority, p.price, p.curr, p.startDate, p.endDate)" +
            "FROM PriceEntity p " +
            "WHERE p.productId = :productId " +
            "AND p.brandId = :brandId " +
            "AND :applicationDate BETWEEN p.startDate AND p.endDate " +
            "ORDER BY p.priority DESC " +
            "LIMIT 1")
    Optional<PriceEntity> findApplicablePrice(@Param("applicationDate") LocalDateTime applicationDate,
                                        @Param("productId") Integer productId,
                                        @Param("brandId") Integer brandId);
}
