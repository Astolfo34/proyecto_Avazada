package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Comentario;
import com.uniquindio.sebas.guia5.dtos.ComentarioRequest;
import com.uniquindio.sebas.guia5.dtos.ComentarioResponse;
import java.time.LocalDate;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-28T21:05:57-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class ComentarioMapperImpl implements ComentarioMapper {

    @Override
    public Comentario toEntity(ComentarioRequest dto) {
        if ( dto == null ) {
            return null;
        }

        Comentario comentario = new Comentario();

        comentario.setContenido_comentario( dto.contenido_comentario() );

        comentario.setId( UUID.randomUUID().toString() );
        comentario.setFechaPublication( LocalDate.now() );

        return comentario;
    }

    @Override
    public ComentarioResponse toResponse(Comentario comentario) {
        if ( comentario == null ) {
            return null;
        }

        String id = null;
        LocalDate fechaPublication = null;
        String creadorId = null;
        String reporteId = null;
        String contenido_comentario = null;

        id = comentario.getId();
        fechaPublication = comentario.getFechaPublication();
        creadorId = comentario.getCreadorId();
        reporteId = comentario.getReporteId();
        contenido_comentario = comentario.getContenido_comentario();

        ComentarioResponse comentarioResponse = new ComentarioResponse( id, creadorId, reporteId, contenido_comentario, fechaPublication );

        return comentarioResponse;
    }
}
