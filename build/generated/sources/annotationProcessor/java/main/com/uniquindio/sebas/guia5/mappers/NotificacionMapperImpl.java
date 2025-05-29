package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Notificacion;
import com.uniquindio.sebas.guia5.doamin.TipoNotificacion;
import com.uniquindio.sebas.guia5.dtos.NotificationDTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-29T05:02:32-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class NotificacionMapperImpl implements NotificacionMapper {

    @Override
    public Notificacion toEntity(NotificationDTO notificationDTO) {
        if ( notificationDTO == null ) {
            return null;
        }

        Notificacion notificacion = new Notificacion();

        notificacion.setId( notificationDTO.id() );
        notificacion.setTipo( notificationDTO.tipoNotificacion() );
        notificacion.setMensaje( notificationDTO.contenido() );
        if ( notificationDTO.fechaNotificacion() != null ) {
            notificacion.setFechaCreada( LocalDateTime.parse( notificationDTO.fechaNotificacion() ) );
        }

        notificacion.setEstadoLeido( false );

        return notificacion;
    }

    @Override
    public NotificationDTO toDto(Notificacion notificacion) {
        if ( notificacion == null ) {
            return null;
        }

        String id = null;
        TipoNotificacion tipoNotificacion = null;
        String contenido = null;
        String fechaNotificacion = null;
        Boolean notificacionLeida = null;

        id = notificacion.getId();
        tipoNotificacion = notificacion.getTipo();
        contenido = notificacion.getMensaje();
        if ( notificacion.getFechaCreada() != null ) {
            fechaNotificacion = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format( notificacion.getFechaCreada() );
        }
        notificacionLeida = notificacion.getEstadoLeido();

        NotificationDTO notificationDTO = new NotificationDTO( id, tipoNotificacion, contenido, fechaNotificacion, notificacionLeida );

        return notificationDTO;
    }
}
