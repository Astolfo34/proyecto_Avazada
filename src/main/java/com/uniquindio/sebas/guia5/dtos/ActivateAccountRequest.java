package com.uniquindio.sebas.guia5.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * Clase que representa la petición de activación de cuenta
 * @param activationCode
 */
public record ActivateAccountRequest(
        @NotNull(message = "El código de activación es requerido")
        String activationCode,
        @NotNull(message = "El correo electrónico es requerido")
        @Email(message = "El correo electrónico debe ser válido")
        String email
) {

}
