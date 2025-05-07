package com.uniquindio.sebas.guia5.dtos;

import org.bson.types.ObjectId;

public record ComentarioDTO(
        ObjectId creadorId,
        ObjectId reporteId,
        String contenido_comentario
) {}
