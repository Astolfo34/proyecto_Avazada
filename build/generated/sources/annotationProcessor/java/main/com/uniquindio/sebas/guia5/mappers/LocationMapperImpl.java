package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Location;
import com.uniquindio.sebas.guia5.dtos.LocationDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-20T02:15:22-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class LocationMapperImpl implements LocationMapper {

    @Override
    public Location toEntity(LocationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Location location = new Location();

        location.setLatitud( LocationMapper.stringToDouble( dto.latitud() ) );
        location.setLongitud( LocationMapper.stringToDouble( dto.longitud() ) );

        return location;
    }

    @Override
    public LocationDTO toDto(Location entity) {
        if ( entity == null ) {
            return null;
        }

        String latitud = null;
        String longitud = null;

        latitud = LocationMapper.doubleToString( entity.getLatitud() );
        longitud = LocationMapper.doubleToString( entity.getLongitud() );

        LocationDTO locationDTO = new LocationDTO( latitud, longitud );

        return locationDTO;
    }
}
