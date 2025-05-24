package com.uniquindio.sebas.guia5.dtos;

import jakarta.validation.constraints.NotNull;

public record LoginDTOresponse(
        String token,
        String mensaje
) {
}
