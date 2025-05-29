package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Comentario;
import com.uniquindio.sebas.guia5.dtos.ComentarioRequest;
import com.uniquindio.sebas.guia5.dtos.ComentarioResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {java.util.UUID.class , java.time.LocalDate.class})
public interface ComentarioMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    @Mapping(target = "fechaPublication", expression = "java(LocalDate.now())")
    @Mapping(target = "creadorId", ignore = true)
    @Mapping(target = "reporteId", ignore = true)
    @Mapping(target = "contenido_comentario", source = "contenido_comentario")

    //De DTO a entidad
    Comentario toEntity(ComentarioRequest dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "fechaPublication", source = "fechaPublication")
    @Mapping(target = "creadorId", source = "creadorId")
    @Mapping(target = "reporteId", source = "reporteId")
    @Mapping(target = "contenido_comentario", source = "contenido_comentario")
    //De entidad a DTO
    ComentarioResponse toResponse(Comentario comentario);
}
