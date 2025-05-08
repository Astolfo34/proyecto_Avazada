package com.uniquindio.sebas.guia5.services.implementations;

import com.uniquindio.sebas.guia5.dtos.NotificationDTO;
import com.uniquindio.sebas.guia5.mappers.NotificacionMapper;
import com.uniquindio.sebas.guia5.repository.NotificacionRepository;
import com.uniquindio.sebas.guia5.services.NotificacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificacionServiceImpl implements NotificacionService {

    private final NotificacionMapper notificacionMapper ;
    private final NotificacionRepository notificacionRepository ;


    @Override
    public List<NotificationDTO> listarTodasLasNotificaciones(String userId) {
        return notificacionRepository.findById(userId)
                .stream()
                .map(notificacionMapper::toDto)
                .toList();
    }

    @Override
    public void eliminarNotificacion (String idNotificacion) {
        notificacionRepository.deleteById(idNotificacion);
    }

}
