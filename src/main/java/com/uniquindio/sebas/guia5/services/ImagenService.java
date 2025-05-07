package com.uniquindio.sebas.guia5.services;

import com.uniquindio.sebas.guia5.doamin.Imagen;
import com.uniquindio.sebas.guia5.dtos.ImagenDTO;
import com.uniquindio.sebas.guia5.dtos.ImagenResponse;
import com.uniquindio.sebas.guia5.mappers.ImagenMapper;
import com.uniquindio.sebas.guia5.repository.ImagenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenService {

    private final ImagenRepository imagenRepository;
    private final ImagenMapper imagenMapper;

    public ImagenService(ImagenRepository imagenRepository, ImagenMapper imagenMapper) {
        this.imagenRepository = imagenRepository;
        this.imagenMapper = imagenMapper;
    }

    public ImagenResponse guardarImagen(ImagenDTO dto) {
        Imagen imagen = imagenMapper.toEntity(dto);
        return imagenMapper.toResponse(imagenRepository.save(imagen));
    }

    public List<ImagenResponse> listarImagenes() {
        return imagenRepository.findAll().stream()
                .map(imagenMapper::toResponse)
                .toList();
    }
}
