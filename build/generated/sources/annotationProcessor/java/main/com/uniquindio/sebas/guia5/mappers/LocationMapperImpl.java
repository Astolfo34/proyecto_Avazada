package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Location;
import com.uniquindio.sebas.guia5.dtos.LocationDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-26T03:29:48-0500",
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

        location.setId( java.util.UUID.randomUUID().toString() );

        return location;
    }

    @Override
    public LocationDTO toDto(Location entity) {
        if ( entity == null ) {
            return null;
        }

        String latitud = null;
        String longitud = null;
        String id = null;

        latitud = LocationMapper.doubleToString( entity.getLatitud() );
        longitud = LocationMapper.doubleToString( entity.getLongitud() );
        id = entity.getId();

        LocationDTO locationDTO = new LocationDTO( latitud, longitud, id );

        return locationDTO;
    }
}
