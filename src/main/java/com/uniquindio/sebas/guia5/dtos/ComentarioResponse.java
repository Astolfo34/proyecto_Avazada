package com.uniquindio.sebas.guia5.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.bson.types.ObjectId;

public record ComentarioResponse(
        @NotNull(message = "el comentario debe contener id")
        String id,
        @NotNull(message = "es necesario el id del creador del comentario")
        String creadorId,
        @NotNull(message = "es necesario el id del reporte al que pertenece el comentario")
        String reporteId,
        @NotNull(message = "el contenido del comentario es necesario")
        @Size(max = 500, message = "el comentario no debe contener mas de 500 caracteres")
        String contenido_comentario,
        @NotNull(message = "la fecha de creacion del comentario es necesaria")
        LocalDate fechaPublication
) {}
