package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Notificacion;
import com.uniquindio.sebas.guia5.doamin.TipoNotificacion;
import com.uniquindio.sebas.guia5.dtos.NotificationDTO;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-08T09:58:13-0500",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.12.1.jar, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class NotificacionMapperImpl implements NotificacionMapper {

    @Override
    public NotificationDTO toDto(Notificacion notificacion) {
        if ( notificacion == null ) {
            return null;
        }

        TipoNotificacion tipoNotificacion = null;

        tipoNotificacion = notificacion.getTipo();

        String id = java.util.UUID.randomUUID().toString();
        String contenido = null;
        String fechaNotificacion = null;
        Boolean notificacionLeida = null;

        NotificationDTO notificationDTO = new NotificationDTO( id, tipoNotificacion, contenido, fechaNotificacion, notificacionLeida );

        return notificationDTO;
    }

    @Override
    public Notificacion toEntity(NotificationDTO notificationDTO) {
        if ( notificationDTO == null ) {
            return null;
        }

        Notificacion notificacion = new Notificacion();

        notificacion.setId( notificationDTO.id() );

        return notificacion;
    }
}
