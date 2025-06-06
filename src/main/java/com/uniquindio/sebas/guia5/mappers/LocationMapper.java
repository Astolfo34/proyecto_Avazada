package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Location;
import com.uniquindio.sebas.guia5.dtos.LocationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface LocationMapper {

    LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "latitud", source = "latitud", qualifiedByName = "stringToDouble")
    @Mapping(target = "longitud", source = "longitud", qualifiedByName = "stringToDouble")
    Location toEntity(LocationDTO dto);

    @Mapping(target = "latitud", source = "latitud", qualifiedByName = "doubleToString")
    @Mapping(target = "longitud", source = "longitud", qualifiedByName = "doubleToString")
    @Mapping(target = "id", source = "id")
    LocationDTO toDto(Location entity);

    @Named("stringToDouble")
    static double stringToDouble(String value) {
        if (value == null) {
            throw new IllegalArgumentException("El valor no puede ser nulo");
        }
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Valor numérico inválido: " + value);
        }
    }

    @Named("doubleToString")
    static String doubleToString(double value) {
        return String.valueOf(value);
    }
}