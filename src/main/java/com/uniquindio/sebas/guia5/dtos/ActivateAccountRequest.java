package com.uniquindio.sebas.guia5.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * Clase que representa la petición de activación de cuenta
 * @param activationCode
 */
public record ActivateAccountRequest(
        @NotBlank(message = "El código de activación es requerido")
        String activationCode) {

}
