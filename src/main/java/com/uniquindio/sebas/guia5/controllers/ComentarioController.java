package com.uniquindio.sebas.guia5.controllers;

import com.uniquindio.sebas.guia5.dtos.ComentarioRequest;
import com.uniquindio.sebas.guia5.dtos.ComentarioResponse;
import com.uniquindio.sebas.guia5.services.ComentarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/reports/{reportId}/comments")
public class ComentarioController {

    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public ResponseEntity<ComentarioResponse> crearComentario(@RequestBody @Valid ComentarioRequest dto, @PathVariable String reportId) { //@RequestHeader("Authorization") String token
        //extraemos el usuario del token, pero por ahora se usara uno de pruebas
        String userId = "usuario de prueba";
        ComentarioResponse response = comentarioService.crearComentario(dto, reportId,userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public List<ComentarioResponse> listarComentarios() {
        return comentarioService.listarComentarios();
    }
}
