package com.uniquindio.sebas.guia5.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uniquindio.sebas.guia5.doamin.Location;
import com.uniquindio.sebas.guia5.doamin.Rol;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que representa la petición de registro de usuario
 * @param email
 * @param password
 * @param fullname
 * @param dateBirth
 * @param rol
 * @param direccion
 * @param telefono
 * @param imagenPerfil
 * @param ubicacionUsuario
 */
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
                                LocalDate dateBirth,    //MANEJAR DENTRO DE LA LOGICA DE NEGOCIO EL OBTENER LA FECHA EN TIEMPO ACTUAL AUTOMATIC
                                Rol rol,
                                @NotBlank(message = "la dirección no puede estar vacía")
                                @Size(max = 100, message = "la dirección no puede superar los 100 caracteres")
                                String direccion,
                                @NotBlank
                                @Pattern(regexp = "^\\\\+?[0-9]{7,15}$", message = "el telefono debe estar en un formato valido, 7-15 digitos, opcionalmete un '+' al inicio")
                                String telefono,
                                @NotBlank(message = "la URL de la imagen no puede estar vacía")
                                @Pattern(regexp = "^(https?://).+\\.(jpg|jpeg|png|gif)$", message = "La imagen de perfil debe ser una URL válida que termine en jpg, jpeg, png o gif")
                                String imagenPerfil,
                                @NotNull(message = "la ubicacion no puede estar vacía")
                                @Valid
                                Location ubicacionUsuario
) {
    public UserRegistration {
        rol = Objects.requireNonNullElse(rol, Rol.USERDEFAULT);
    }
}
