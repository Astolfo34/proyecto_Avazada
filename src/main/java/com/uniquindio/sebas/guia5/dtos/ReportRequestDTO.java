package com.uniquindio.sebas.guia5.dtos;

import com.uniquindio.sebas.guia5.doamin.Imagen;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ReportRequestDTO(@NotBlank(message = "el titulo es requerido")
                               @Size(min = 20,max = 150,message = "el titulo debe tener entre 20 y 150 caracteres")
                               String title,
                               @NotBlank(message = "el contenido es requerido")
                               @Size(max = 1000, message = "el contenido del reporte no debe exeder los 1000 caracteres")
                               String content,
                               @NotNull(message = "la imagen es requerida")
                               Imagen image

                               ) {
}
