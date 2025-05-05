package com.uniquindio.sebas.guia5.dtos;

import com.uniquindio.sebas.guia5.doamin.TipoNotificacion;
import jakarta.validation.constraints.NotNull;

/**
 * Dto que representa las notificaciones
 * @param id
 * @param tipoNotificacion
 * @param contenido
 * @param fechaNotificacion
 * @param notificacionLeida
 */
public record NotificationDTO(
        String id,
        @NotNull
        TipoNotificacion tipoNotificacion,
        String contenido,
        String fechaNotificacion,
        Boolean notificacionLeida
) {
}
