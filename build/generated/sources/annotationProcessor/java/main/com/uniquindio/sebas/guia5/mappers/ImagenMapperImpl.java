package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Imagen;
import com.uniquindio.sebas.guia5.dtos.ImagenDTO;
import com.uniquindio.sebas.guia5.dtos.ImagenResponse;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-14T19:10:00-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class ImagenMapperImpl implements ImagenMapper {

    @Override
    public Imagen toEntity(ImagenDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Imagen imagen = new Imagen();

        imagen.setRuta( dto.ruta() );
        imagen.setNombre( dto.nombre() );

        imagen.setId( UUID.randomUUID().toString() );

        return imagen;
    }

    @Override
    public ImagenResponse toResponse(Imagen imagen) {
        if ( imagen == null ) {
            return null;
        }

        String id = null;
        String ruta = null;
        String nombre = null;

        id = imagen.getId();
        ruta = imagen.getRuta();
        nombre = imagen.getNombre();

        ImagenResponse imagenResponse = new ImagenResponse( id, ruta, nombre );

        return imagenResponse;
    }
}
