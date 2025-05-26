package com.uniquindio.sebas.guia5.controllers;

import com.uniquindio.sebas.guia5.dtos.ComentarioRequest;
import com.uniquindio.sebas.guia5.dtos.ComentarioResponse;
import com.uniquindio.sebas.guia5.services.ComentarioService;
import com.uniquindio.sebas.guia5.services.implementations.ComentarioServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/reports/{reportId}/comments")
@AllArgsConstructor
public class ComentarioController {

    private final ComentarioService comentarioService;


    @PostMapping
    public ResponseEntity<ComentarioResponse> crearComentario(@RequestBody @Valid ComentarioRequest request, @PathVariable String reportId) { //@RequestHeader("Authorization") String token
        // Obtener email del usuario desde el JWT
        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        try{
            ComentarioResponse response = comentarioService.crearComentario(request,reportId,userEmail);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            e.printStackTrace();
            return  ResponseEntity.badRequest().build();
        }
    }

}
