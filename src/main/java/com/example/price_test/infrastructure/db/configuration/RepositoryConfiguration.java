package com.example.price_test.infrastructure.db.configuration;

import com.example.price_test.infrastructure.db.repository.PriceRepositoryImpl;
import com.example.price_test.domain.repository.PriceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public PriceRepository priceRepository(PriceRepositoryImpl priceRepository) {
        return priceRepository;
    }
}
