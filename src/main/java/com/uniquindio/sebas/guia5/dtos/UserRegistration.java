package com.uniquindio.sebas.guia5.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uniquindio.sebas.guia5.doamin.Rol;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Objects;


public record UserRegistration (@NotBlank(message = "Este campo es requerido")
                                @Email(message = "Debe contener un email valido")
                                String email,
                                @NotBlank(message = "El campo es requerido")
                                @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$",message = "Debe contener al menos: Un numero, Una letra minuscula y Una letra mayuscula ")
                                @Size(min = 8,message = "Debe contener al menos 8 caracteres")
                                String password,
                                @NotBlank(message = "Este campo es requerido")
                                @Size(max = 100, message = "el nombre de usuario no debe sobrepasar 100 caracteres")
                                String fullname,
                                @NotNull (message = "La fecha es requerida")
                                @PastOrPresent(message = "La Fecha no puede ser furura. no tiene sentido")
                                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                                LocalDate dateBirth,
                                Rol rol) {
    public UserRegistration {
        rol = Objects.requireNonNullElse(rol, Rol.USERDEFAULT);
    }
}
