package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Comentario;
import com.uniquindio.sebas.guia5.dtos.ComentarioDTO;
import com.uniquindio.sebas.guia5.dtos.ComentarioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.time.LocalDateTime;
import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ComentarioMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    @Mapping(target = "fechaCreacion", expression = "java(LocalDateTime.now())")
    Comentario toEntity(ComentarioDTO dto);

    ComentarioResponse toResponse(Comentario comentario);
}
