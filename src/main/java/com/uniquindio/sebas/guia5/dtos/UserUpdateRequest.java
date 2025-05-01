package com.uniquindio.sebas.guia5.dtos;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.uniquindio.sebas.guia5.doamin.Imagen;
import com.uniquindio.sebas.guia5.doamin.Location;
import com.uniquindio.sebas.guia5.doamin.Rol;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Objects;

    /**
     * Este objeto de transferencia, se espera dentro del diseño, que solo maneje
     * las actualizaciones de los usuarios que haga un UserAdmin , ya que para las
     * actualizaciones propias de los usuarios debe existir el PATCH
     * @param-dateBirth -----{AUN EN DISCUSIÓN}-----se supone que un usuario no necesita modificar el día en que nació
     * @param fullName
     * @param-rol  -----{AUN EN DISCUSIÓN}-----se supone que debe ser operable para PUT | PATCH
     */
public record UserUpdateRequest(
                            @NotBlank (message = "el campo es necesario para la operacion")
                            @Size (max = 80, message = "el nombre no debe superar los 80 caracteres")
                            String fullName,
                            @NotBlank
                            @Email(message = "el correo debe ser valido existente")
                            String email,
                            //Rol rol, //no es necesario, ya que el rol no se puede cambiar solo por una modificación externa
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

}
