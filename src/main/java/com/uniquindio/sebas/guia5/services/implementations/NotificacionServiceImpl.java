package com.uniquindio.sebas.guia5.services.implementations;

import com.uniquindio.sebas.guia5.doamin.*;
import com.uniquindio.sebas.guia5.dtos.NotificationDTO;
import com.uniquindio.sebas.guia5.mappers.NotificacionMapper;
import com.uniquindio.sebas.guia5.repository.NotificacionRepository;
import com.uniquindio.sebas.guia5.repository.UserRepository;
import com.uniquindio.sebas.guia5.services.NotificacionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class NotificacionServiceImpl implements NotificacionService {

    private final NotificacionMapper notificacionMapper ;
    private final NotificacionRepository notificacionRepository ;
    private UserRepository userRepository;

    /*@org.springframework.beans.factory.annotation.Autowired
    public NotificacionServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/


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

    @Override
    public void notificarUsuario(String usuarioId, String mensaje) {
        Notificacion n = new Notificacion(null, TipoNotificacion.NEW_NEARBY_REPORT,mensaje,LocalDateTime.now(), false);
        notificacionRepository.save(n);
    }
    @Override
    public void notificarUsuariosCercanos(Location ubicacionReporte, String mensaje) {
        List<User> usuarios = userRepository.findAll();
        Location prueba = new Location(null,4.0, 3.0); // Ubicación de prueba para la distancia
        for (User u : usuarios) {
            if (distancia(prueba, ubicacionReporte) <= 2.0) {
                notificarUsuario(u.getId(), mensaje);
            }
        }
    }
    private double distancia(Location a, Location b) {
        // fórmula Haversine simplificada para radios cortos
        double R = 6371; // km
        double dLat = Math.toRadians(b.getLatitud() - a.getLatitud());
        double dLon = Math.toRadians(b.getLongitud() - a.getLongitud());
        double lat1 = Math.toRadians(a.getLatitud());
        double lat2 = Math.toRadians(b.getLatitud());

        double aCalc = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(aCalc), Math.sqrt(1-aCalc));
        return R * c;
    }
    @Override
    public void notificarAdministradores(String mensaje) {
        /*List<User> admins = userRepository.findByRol(String.valueOf(Rol.ADMINISTRATOR));
        for (User admin : admins) {
            notificarUsuario(admin.getId(), mensaje);
        }*/
    }
    /*@Override
    public List<NotificationDTO> obtenerPorUsuario(String usuarioId) {
        return notificacionRepository.findByUsuarioId(usuarioId).stream()
                .map(mapper::toDto).toList();
    }*/
}
