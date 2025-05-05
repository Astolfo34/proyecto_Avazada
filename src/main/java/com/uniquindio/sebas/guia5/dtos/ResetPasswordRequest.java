package com.uniquindio.sebas.guia5.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * DTO para la peticion de restablecimiento de contraseña--> depende del uso previo del DTO RecoverPasswordRequest
 * @param email
 * @param currentPassword
 * @param newPassword
 * @param verificationCode
 */
public record ResetPasswordRequest(
        @NotBlank(message = "el email es requerido")
        @Email
        String email,
        @NotBlank(message = "ingrese la ultima contraseña que recuerda")
        @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$", message = "El campo debe contener minimo 1 letra minuscula, 1 mayuscula y 1 numero")
        @Size(min = 8, message = "Debe contener como minimo 8 caracteres")
        String currentPassword,
        @NotBlank(message = "ingrese la nueva contraseña")
        @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$", message = "El campo debe contener minimo 1 letra minuscula, 1 mayuscula y 1 numero")
        @Size(min = 8, message = "Debe contener como minimo 8 caracteres")
        String newPassword,
        @NotBlank(message = "ingrese el codigo de verificacion")
        @Size(min = 4, max = 4, message = "El codigo de verificacion debe tener 4 digitos")
        String verificationCode
) {
}
