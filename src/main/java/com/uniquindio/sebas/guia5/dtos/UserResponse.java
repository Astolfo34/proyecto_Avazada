package com.uniquindio.sebas.guia5.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uniquindio.sebas.guia5.doamin.Rol;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserResponse(@NotBlank (message = "El campo es requerido")
                           String id,
                           @NotBlank(message = "El campo es requerido")
                           @Email(message = "ingrese un email valido")
                           String email,
                           @NotBlank(message = "El campo es necesario")
                           @Pattern (regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$" , message = "Debe contener al menos 1 mayuscula y 1 minuscula")
                           @Size(max = 100, message = "No debe sobrepasar los 100 caracteres")
                           String fullName,
                           @NotNull(message = "la fecha no puede estar vacida")
                           @PastOrPresent(message = "la fecha de nacimiento no puede estar en el futuro")
                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                           LocalDate dateBirth,
                           Rol rol ) {

}
