package com.uniquindio.sebas.guia5.dtos;

import jakarta.validation.constraints.*;
public record ErrorResponse(String type , String message) {
}
