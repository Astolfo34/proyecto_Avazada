package com.uniquindio.sebas.guia5.dtos;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.uniquindio.sebas.guia5.doamin.Rol;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Objects;

    /**
     * Este objeto de transferencia, se espera dentro del diseño, que solo maneje
     * las actualizaciones de los usuarios que haga un UserAdmin , ya que para las
     * actualizaciones propias de los usuarios debe existir el PATCH
     * @param dateBirth
     * @param fullName
     * @param rol
     */
public record UpdateUserPut(
                            @NotBlank (message = "este campo es requerido")
                            @PastOrPresent (message = "la fecha de nacimiento no puede ser futura")
                            @JsonFormat ( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                            LocalDate dateBirth,
                            @NotBlank (message = "el campo es necesario para la operacion")
                            @Size (max = 80, message = "el nombre no debe superar los 80 caracteres")
                            String fullName,
                            Rol rol
) {
    public UpdateUserPut {
        rol = Objects.requireNonNullElse(rol, Rol.USERDEFAULT);
    }
}
