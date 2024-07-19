package com.example.price_test.infrastructure.mapper;

import com.example.dto.PriceDto;
import com.example.price_test.domain.model.Price;
import com.example.price_test.infrastructure.entity.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Mapper
public interface PriceMapper {
    PriceMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(PriceMapper.class);

    @Mapping(target = "id", source = "priceList")
    @Mapping(target = "currency", source = "curr")
    Price toModel(PriceEntity priceEntity);

    @Mapping(target = "priceList", source = "id")
    @Mapping(target = "curr", source = "currency")
    @Mapping(target = "startDate", source = "startDate", qualifiedByName = "localDateTimeToOffsetDateTime")
    @Mapping(target = "endDate", source = "endDate", qualifiedByName = "localDateTimeToOffsetDateTime")
    PriceDto toDto(Price price);

    @Named("localDateTimeToOffsetDateTime")
    default OffsetDateTime LocalDateTimeToOffsetDateTime(LocalDateTime localDateTime) {
        return localDateTime.atOffset(java.time.ZoneOffset.UTC);
    }
}
