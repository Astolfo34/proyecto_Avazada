package com.uniquindio.sebas.guia5.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Esta clase es un DTO que representa la solicitud de recuperación de contraseña.
 * @param emailDe_laCuenta
 */
public record RecoverPasswordRequest(
        @NotBlank(message = "El correo a recuperar la pass no puede estar vacío")
        @Email(message = "el correo debe ser valido")
        String emailDe_laCuenta
) {
}
