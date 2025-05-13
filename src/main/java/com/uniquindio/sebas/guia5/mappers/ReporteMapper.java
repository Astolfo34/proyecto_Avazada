package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Reporte;
import com.uniquindio.sebas.guia5.dtos.ReportResponse;
import com.uniquindio.sebas.guia5.dtos.ReporteDTO;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.Target;

/**
 * Clase Mapper para la entidad Reporte.
 * permitiendo la conversión entre la entidad Reporte y su representación en la base de datos.
 * convirtiendo entre entidad y su DTO
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReporteMapper {

    ReporteMapper INSTANCE = Mappers.getMapper(ReporteMapper.class);

    @Mapping(target = "userId", ignore = true )// ignorado por ahora mientras pruebas
    @Mapping(target = "id",expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "location", source = "location")
    @Mapping(target = "title",source = "title")
    @Mapping(target = "content", source = "content")
    @Mapping(target = "imageUrl", source = "imageUrl")
    @Mapping(target = "occurrenceDate", source = "occurrenceDate")
    @Mapping(target = "categories", source = "categories")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "status", constant = "PENDIENTE")
    @Mapping(target = "listComments", ignore = true)
    @Mapping(target = "importanceCount", ignore = true)
    Reporte parseOf(ReporteDTO reporteDTO);


    ReportResponse toReportResponse(Reporte reporte);


    @Named("objectIdToString")
    static String objectIdToString(ObjectId objectId){
        return objectId != null ? objectId.toHexString() : null;
    }

    @Named("stringToObjectId")
    static ObjectId stringToObjectId(String id){
        return id != null ? new ObjectId(id) : null;
    }

}
