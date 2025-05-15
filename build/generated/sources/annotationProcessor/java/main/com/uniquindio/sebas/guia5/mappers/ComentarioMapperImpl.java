package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Comentario;
import com.uniquindio.sebas.guia5.dtos.ComentarioDTO;
import com.uniquindio.sebas.guia5.dtos.ComentarioResponse;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-14T19:10:00-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class ComentarioMapperImpl implements ComentarioMapper {

    private final DatatypeFactory datatypeFactory;

    public ComentarioMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

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
        comentario.setFechaCreacion( LocalDate.now() );

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
        fechaCreacion = xmlGregorianCalendarToLocalDateTime( localDateToXmlGregorianCalendar( comentario.getFechaCreacion() ) );

        ComentarioResponse comentarioResponse = new ComentarioResponse( id, creadorId, reporteId, contenido_comentario, fechaCreacion );

        return comentarioResponse;
    }

    private XMLGregorianCalendar localDateToXmlGregorianCalendar( LocalDate localDate ) {
        if ( localDate == null ) {
            return null;
        }

        return datatypeFactory.newXMLGregorianCalendarDate(
            localDate.getYear(),
            localDate.getMonthValue(),
            localDate.getDayOfMonth(),
            DatatypeConstants.FIELD_UNDEFINED );
    }

    private static LocalDateTime xmlGregorianCalendarToLocalDateTime( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        if ( xcal.getYear() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMonth() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getDay() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getHour() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMinute() != DatatypeConstants.FIELD_UNDEFINED
        ) {
            if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED
                && xcal.getMillisecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond(),
                    Duration.ofMillis( xcal.getMillisecond() ).getNano()
                );
            }
            else if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond()
                );
            }
            else {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute()
                );
            }
        }
        return null;
    }
}
