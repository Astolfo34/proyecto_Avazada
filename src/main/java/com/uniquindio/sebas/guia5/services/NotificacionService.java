package com.uniquindio.sebas.guia5.services;

import com.uniquindio.sebas.guia5.doamin.Location;
import com.uniquindio.sebas.guia5.dtos.NotificationDTO;

import java.util.List;


public interface NotificacionService {


    List<NotificationDTO> listarTodasLasNotificaciones (String userId);

    void eliminarNotificacion (String idNotificacion);

    void notificarUsuario(String usuarioId, String mensaje);
    void notificarUsuariosCercanos(Location ubicacionReporte, String mensaje);
    void notificarAdministradores(String mensaje);
    /*List<NotificationDTO> obtenerPorUsuario(String usuarioId);*/

}
