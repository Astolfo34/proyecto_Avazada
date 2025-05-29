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
        @NotNull(message = "el contenido es requerido")
        @Size(min = 5, max = 500, message = "máximo 500 caracteres en el cometario")
        String contenido_comentario

) {}
