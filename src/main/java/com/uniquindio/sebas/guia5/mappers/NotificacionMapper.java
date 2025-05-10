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


    @Mapping(target = "id",expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "tipoNotificacion", source = "tipo")
    NotificationDTO toDto(Notificacion notificacion);

    Notificacion toEntity(NotificationDTO notificationDTO);
}
