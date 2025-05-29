package com.uniquindio.sebas.guia5.mappers;

import com.uniquindio.sebas.guia5.doamin.Notificacion;
import com.uniquindio.sebas.guia5.dtos.NotificationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
imports = {java.util.UUID.class})
public interface NotificacionMapper {


    @Mapping(target = "id",source = "id")
    @Mapping(target = "tipo", source = "tipoNotificacion")
    @Mapping(target = "mensaje", source = "contenido")
    @Mapping(target = "fechaCreada", source = "fechaNotificacion")
    @Mapping(target = "estadoLeido", constant = "false")
    Notificacion toEntity(NotificationDTO notificationDTO);



    @Mapping(target = "id",source = "id")
    @Mapping(target = "tipoNotificacion", source = "tipo")
    @Mapping(target = "contenido", source = "mensaje")
    @Mapping(target = "fechaNotificacion", source = "fechaCreada")
    @Mapping(target = "notificacionLeida", source = "estadoLeido")
    NotificationDTO toDto(Notificacion notificacion);


}
