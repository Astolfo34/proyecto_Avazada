package com.uniquindio.sebas.guia5.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uniquindio.sebas.guia5.doamin.EstadoReporte;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Clase que representa las solicitudes de creacion de un reporte
 * @param title
 * @param content
 * @param estado
 * @param fechaOcurrencia
 */
public record ReportUpdateRequest(
        @NotBlank(message = "el campo es requerido")
        @Size(min= 20, max = 150 , message = "el campo no debe superar 150 caracteres")
        String title,
        @NotBlank(message = "el campo es requerido")
        @Size(min = 20,max = 1000, message = "por lo menos contener una breve descripcion")
        String content,
        @NotNull(message = "el estado actual del reporte es requerido")
        EstadoReporte estado,
        @NotBlank(message = "la fecha es requerida en que sucedió el suceso")
        @PastOrPresent(message = "La Fecha no puede ser furura. no tiene sentido")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        String fechaOcurrencia
) {
}
