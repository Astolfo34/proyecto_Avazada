package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Reporte;
import com.uniquindio.sebas.guia5.dtos.ReporteDTO;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * Clase Mapper para la entidad Reporte.
 * permitiendo la conversión entre la entidad Reporte y su representación en la base de datos.
 * convirtiendo entre entidad y su DTO
 */
@Mapper
public interface ReporteMapper {

    ReporteMapper INSTANCE = Mappers.getMapper(ReporteMapper.class);

    @Mapping(target = "userId", source = "userId", qualifiedByName = "objectIdToString" )
    ReporteDTO toDto(Reporte reporte);

    @Mapping(target = "userId", source = "userId", qualifiedByName = "stringToObjectId" )
    Reporte toEntity(ReporteDTO reporteDTO);

    @Named("objectIdToString")
    static String objectIdToString(ObjectId objectId){
        return objectId != null ? objectId.toHexString() : null;
    }

    @Named("stringToObjectId")
    static ObjectId stringToObjectId(String id){
        return id != null ? new ObjectId(id) : null;
    }

}
