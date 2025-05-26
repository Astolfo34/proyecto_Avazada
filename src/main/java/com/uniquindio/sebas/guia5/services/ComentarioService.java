package com.uniquindio.sebas.guia5.services;

import com.uniquindio.sebas.guia5.dtos.ComentarioRequest;
import com.uniquindio.sebas.guia5.dtos.ComentarioResponse;

public interface ComentarioService {
    ComentarioResponse crearComentario (ComentarioRequest request, String reportId, String userId);
}
