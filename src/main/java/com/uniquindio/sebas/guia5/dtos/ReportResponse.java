package com.uniquindio.sebas.guia5.dtos;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.mapstruct.Builder;

import java.util.List;

/**
 * clase que representa la respuesta de un reporte
 * @param id
 * @param title
 * @param contenido
 * @param image
 * @param latitud
 * @param longitud
 * @param categoriasdIds
 * @param fechaSuceso
 * @param nombreUsuario
 */

public record ReportResponse(
        @NotNull(message = "el id es requerido")
        Long id,
        @NotNull
        @Size(min = 20,max = 150,message = "el titulo debe tener entre 20 y 150 caracteres")
        String title,
        @NotNull
        @Size(max = 1000, message = "el contenido del reporte no debe exeder los 1000 caracteres")
        String contenido,
        @NotNull
        @URL
        String image,
        @NotNull(message = "la latitud es requerida")
        @DecimalMin(value = "-90",inclusive = true, message = "la latitud debe ser mayor a -90")
        @DecimalMax(value = "90",inclusive = true, message = "la latitud debe ser menor a 90")
        String latitud,
        @NotNull(message = "la longitud es requerida")
        @DecimalMin(value = "-180",inclusive = true, message = "la latitud debe ser mayor a -180")
        @DecimalMax(value = "180",inclusive = true, message = "la latitud debe ser menor a 180")
        String longitud,
        @NotEmpty(message = "el arreglo de Ids de categorias es requerido")
        @Size(min = 1, message = "el arreglo de categorias es requrido con al menos 1 elemento")
        List<Long> categoriasdIds,
        @NotBlank(message = "la fecha del suceso es requerida")
        @PastOrPresent(message = "La Fecha no puede ser furura. no tiene sentido")
        String fechaSuceso,
        String nombreUsuario
) {
}
