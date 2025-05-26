package com.uniquindio.sebas.guia5.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.bson.types.ObjectId;

/**
 * Representacion del objeto de la entidad que se tendra como respuesta
 * @param id
 * @param creadorId ojo debe ser el id pero por ahora el jwt esta dando el email autenticado que ha hecho el comentario
 * @param reporteId
 * @param contenido_comentario
 * @param fechaPublication
 */

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
