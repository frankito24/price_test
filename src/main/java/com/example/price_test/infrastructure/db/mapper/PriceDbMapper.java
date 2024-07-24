package com.example.price_test.infrastructure.db.mapper;

import com.example.price_test.domain.model.Price;
import com.example.price_test.infrastructure.db.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PriceDbMapper {
    PriceDbMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(PriceDbMapper.class);

    @Mapping(target = "id", source = "priceList")
    @Mapping(target = "currency", source = "curr")
    Price toModel(PriceEntity priceEntity);
}
