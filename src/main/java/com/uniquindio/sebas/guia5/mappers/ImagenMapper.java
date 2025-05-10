package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Imagen;
import com.uniquindio.sebas.guia5.dtos.ImagenDTO;
import com.uniquindio.sebas.guia5.dtos.ImagenResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {java.util.UUID.class})
public interface ImagenMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    Imagen toEntity(ImagenDTO dto);

    ImagenResponse toResponse(Imagen imagen);
}
