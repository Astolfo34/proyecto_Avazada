package com.uniquindio.sebas.guia5.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record ComentarioRequest(
        /*@NotNull(message = "el id del creador del comentario es requerido")
        String creadorId,
        @NotNull(message = "el id del reporte del comentario es requerido")
        String reporteId,*/
        @Size(min = 5, max = 500, message = "máximo 500 caracteres en el cometario")
        String contenido_comentario
        /*@NotNull(message = "es necesaria la fecha de creación del comentario")
        @PastOrPresent(message = "La Fecha no puede ser furura. no tiene sentido")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate fechaPublication*/
) {}
