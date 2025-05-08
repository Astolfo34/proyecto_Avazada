package com.uniquindio.sebas.guia5.services;

import com.uniquindio.sebas.guia5.doamin.Location;
import com.uniquindio.sebas.guia5.dtos.LocationDTO;
import com.uniquindio.sebas.guia5.mappers.LocationMapper;
import com.uniquindio.sebas.guia5.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationService(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }
    public LocationDTO guardarUbicacion (LocationDTO locationDTO) {
        Location ubicacion = locationMapper.toEntity(locationDTO);
        return locationMapper.toDto(locationRepository.save(ubicacion));
    }

    public List<LocationDTO> listarUbicaciones() {
        return locationRepository.findAll().stream()
                .map(locationMapper::toDto)
                .toList();
    }
}
