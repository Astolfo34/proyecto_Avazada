package com.uniquindio.sebas.guia5.controllers;

import com.uniquindio.sebas.guia5.dtos.ComentarioDTO;
import com.uniquindio.sebas.guia5.dtos.ComentarioResponse;
import com.uniquindio.sebas.guia5.services.ComentarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comentarios")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public ComentarioResponse crearComentario(@RequestBody ComentarioDTO dto) {
        return comentarioService.crearComentario(dto);
    }

    @GetMapping
    public List<ComentarioResponse> listarComentarios() {
        return comentarioService.listarComentarios();
    }
}
