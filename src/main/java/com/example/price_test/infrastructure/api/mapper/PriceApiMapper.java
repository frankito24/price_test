package com.example.price_test.infrastructure.api.mapper;

import com.api.generated.dto.PriceDto;
import com.example.price_test.domain.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Mapper
public interface PriceApiMapper {
    PriceApiMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(PriceApiMapper.class);

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
