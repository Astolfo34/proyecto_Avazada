package com.uniquindio.sebas.guia5.controllers;

import com.uniquindio.sebas.guia5.dtos.NotificationDTO;
import com.uniquindio.sebas.guia5.services.NotificacionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/notifications")
@RequiredArgsConstructor
public class NotificacionController {

    private final NotificacionService notificacionService ;

    @GetMapping()
    public ResponseEntity<List<NotificationDTO>>  listarTodasLasNotificacionesDeUser(@PathVariable String userId) {
        return ResponseEntity.ok(notificacionService.listarTodasLasNotificaciones(userId));
    }

}
