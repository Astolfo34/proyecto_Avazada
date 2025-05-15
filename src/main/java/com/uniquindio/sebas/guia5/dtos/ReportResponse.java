package com.uniquindio.sebas.guia5.dtos;

import com.uniquindio.sebas.guia5.doamin.Categoria;
import com.uniquindio.sebas.guia5.doamin.Comentario;
import com.uniquindio.sebas.guia5.doamin.EstadoReporte;
import com.uniquindio.sebas.guia5.doamin.Location;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.mapstruct.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * clase que representa la respuesta de un reporte
 * @param id
 * @param title
 * @param contenido
 * @param image
 * @param location
 * @param categories
 * @param fechaSuceso
 * @param userId
 */
public record ReportResponse(
        @NotNull(message = "el id es requerido")
        String id,
        @NotNull
        @Size(min = 20,max = 150,message = "el titulo debe tener entre 20 y 150 caracteres")
        String title,
        @NotNull
        @Size(max = 1000, message = "el contenido del reporte no debe exeder los 1000 caracteres")
        String contenido,
        @NotNull
        @URL
        String image,
        Location location,
        @NotEmpty(message = "el arreglo de Ids de categorias es requerido")
        @Size(min = 1, message = "el arreglo de categorias es requrido con al menos 1 elemento")
        List<Categoria> categories,
        @NotNull(message = "la fecha del suceso es requerida")
        @PastOrPresent(message = "La Fecha no puede ser furura. no tiene sentido")
        LocalDate fechaSuceso,
        String userId,
        List<Comentario>comments,
        Integer importanceCount,
        EstadoReporte status,
        String creadorId
) {
}
