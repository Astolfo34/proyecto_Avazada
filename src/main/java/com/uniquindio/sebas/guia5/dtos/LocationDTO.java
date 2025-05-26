package com.uniquindio.sebas.guia5.dtos;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

/**
 * representacion de la ubicacion en dto
 * @param latitud
 * @param longitud
 */
public record LocationDTO(
        @NotNull(message = "la latitud es requerida")
        @DecimalMin(value = "-90",inclusive = true, message = "la latitud debe ser mayor a -90")
        @DecimalMax(value = "90",inclusive = true, message = "la latitud debe ser menor a 90")
        String latitud,
        @NotNull(message = "la longitud es requerida")
        @DecimalMin(value = "-180",inclusive = true, message = "la latitud debe ser mayor a -180")
        @DecimalMax(value = "180",inclusive = true, message = "la latitud debe ser menor a 180")
        String longitud,
        String id
) {
}
