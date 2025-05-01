package com.uniquindio.sebas.guia5.dtos;

import jakarta.validation.constraints.*;
public record PasswordUpdate(@NotBlank(message = "Este campo es requerido para la operacion")
                             @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$", message = "El campo debe contener minimo 1 letra minuscula, 1 mayuscula y 1 numero")
                             @Size(min = 8, message = "Debe contener como minimo 8 caracteres")
                             String currentPassword,
                             @NotBlank(message = "Este campo es requerido para la operacion")
                             @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$", message = "El campo debe contener minimo 1 letra minuscula, 1 mayuscula y 1 numero")
                             @Size(min = 8, message = "Debe contener como minimo 8 caracteres")
                             String newpassword


) {
}
