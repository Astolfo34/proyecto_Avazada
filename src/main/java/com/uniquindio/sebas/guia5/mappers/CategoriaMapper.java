package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Categoria;
import com.uniquindio.sebas.guia5.dtos.CategoriaDTO;
import com.uniquindio.sebas.guia5.dtos.CategoriaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoriaMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    Categoria toEntity(CategoriaDTO dto);

    CategoriaResponse toResponse(Categoria categoria);
}
