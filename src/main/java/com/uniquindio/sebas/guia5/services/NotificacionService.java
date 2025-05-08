package com.uniquindio.sebas.guia5.services;

import com.uniquindio.sebas.guia5.dtos.NotificationDTO;

import java.util.List;


public interface NotificacionService {


    List<NotificationDTO> listarTodasLasNotificaciones (String userId);

    void eliminarNotificacion (String idNotificacion);

}
