package com.uniquindio.sebas.guia5.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * Clase que representa la petición de activación de cuenta
 * @param activationCode
 * @param correoActivation
 */
public record ActivateAccountRequest(
        @NotBlank(message = "el campo de codigo de activacion no puede estar vacio")
        @Pattern(regexp = "^[0-9]{4}$", message = "el codigo debe contener cuatro digitos")
        String activationCode,
        @NotBlank(message = "el campo de correo no puede estar vacio")
        @Email(message = "el correo debe ser valido en formato ca@cb.com")
        String correoActivation
) {
}
