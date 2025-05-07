package com.uniquindio.sebas.guia5.controllers;

import com.uniquindio.sebas.guia5.dtos.ImagenDTO;
import com.uniquindio.sebas.guia5.dtos.ImagenResponse;
import com.uniquindio.sebas.guia5.services.ImagenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/imagenes")
public class ImagenController {

    private final ImagenService imagenService;

    public ImagenController(ImagenService imagenService) {
        this.imagenService = imagenService;
    }

    @PostMapping
    public ImagenResponse guardarImagen(@RequestBody ImagenDTO dto) {
        return imagenService.guardarImagen(dto);
    }

    @GetMapping
    public List<ImagenResponse> listarImagenes() {
        return imagenService.listarImagenes();
    }
}
