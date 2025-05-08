package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Comentario;
import com.uniquindio.sebas.guia5.dtos.ComentarioDTO;
import com.uniquindio.sebas.guia5.dtos.ComentarioResponse;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-08T01:45:02-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class ComentarioMapperImpl implements ComentarioMapper {

    @Override
    public Comentario toEntity(ComentarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Comentario comentario = new Comentario();

        comentario.setCreadorId( dto.creadorId() );
        comentario.setReporteId( dto.reporteId() );
        comentario.setContenido_comentario( dto.contenido_comentario() );

        comentario.setId( UUID.randomUUID().toString() );
        comentario.setFechaCreacion( LocalDateTime.now() );

        return comentario;
    }

    @Override
    public ComentarioResponse toResponse(Comentario comentario) {
        if ( comentario == null ) {
            return null;
        }

        String id = null;
        ObjectId creadorId = null;
        ObjectId reporteId = null;
        String contenido_comentario = null;
        LocalDateTime fechaCreacion = null;

        id = comentario.getId();
        creadorId = comentario.getCreadorId();
        reporteId = comentario.getReporteId();
        contenido_comentario = comentario.getContenido_comentario();
        fechaCreacion = comentario.getFechaCreacion();

        ComentarioResponse comentarioResponse = new ComentarioResponse( id, creadorId, reporteId, contenido_comentario, fechaCreacion );

        return comentarioResponse;
    }
}
