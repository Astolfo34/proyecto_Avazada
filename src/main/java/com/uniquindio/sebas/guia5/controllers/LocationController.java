package com.uniquindio.sebas.guia5.controllers;

import com.uniquindio.sebas.guia5.dtos.LocationDTO;
import com.uniquindio.sebas.guia5.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ubicaciones")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    public LocationDTO guardarUbicacion (@RequestBody LocationDTO locationDTO) {
        return locationService.guardarUbicacion(locationDTO);
    }

    @GetMapping
    public List<LocationDTO> listarUbicaciones() {
        return locationService.listarUbicaciones();
    }

}
