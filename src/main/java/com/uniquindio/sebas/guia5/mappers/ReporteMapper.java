package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Reporte;
import com.uniquindio.sebas.guia5.dtos.ReportRequest;
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

    @Mapping(target = "userId", source = "userId_creador")// ignorado por ahora mientras pruebas pero es source = "userId_creador"
    @Mapping(target = "id",expression = "java(java.util.UUID.randomUUID().toString())") // del reporte
    @Mapping(target = "location", source = "location" )
    @Mapping(target = "title",source = "title")
    @Mapping(target = "content", source = "contenido")
    @Mapping(target = "imageUrl", source = "image")
    @Mapping(target = "occurrenceDate", source = "fechaSuceso", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "categories", source = "categories" )
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "status", source = "status")
    @Mapping(target = "listComments", ignore = true)
    @Mapping(target = "importanceCount",source = "importanceCount")
    Reporte parseOf(ReportRequest reporteDTO); // mapear de reporteDTO a reporte entidad

    @Mapping(target = "id", source = "id") // Mapear el ID
    @Mapping(target = "title", source = "title") // Mapear el título
    @Mapping(target = "contenido", source = "content") // Mapear el contenido
    @Mapping(target = "image", source = "imageUrl") // Mapear la URL de la imagen
    @Mapping(target = "location", source = "location") // Mapear la ubicación
    @Mapping(target = "categories", source = "categories") // Mapear las categorías
    @Mapping(target = "fechaSuceso", source = "occurrenceDate", dateFormat = "yyyy-MM-dd") // Convertir la fecha
    @Mapping(target = "userId", source = "userId") // Mapear el ID del usuario
    @Mapping(target = "comments", source = "listComments") // Mapear los comentarios
    @Mapping(target = "importanceCount", source = "importanceCount") // Mapear la importancia
    @Mapping(target = "status", source = "status") // Mapear el estado
    @Mapping(target = "creadorId", source = "userId") // Mapear el ID del creador
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
