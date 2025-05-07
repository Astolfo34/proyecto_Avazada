package com.uniquindio.sebas.guia5.dtos;

import java.time.LocalDateTime;
import org.bson.types.ObjectId;

public record ComentarioResponse(
        String id,
        ObjectId creadorId,
        ObjectId reporteId,
        String contenido_comentario,
        LocalDateTime fechaCreacion
) {}
