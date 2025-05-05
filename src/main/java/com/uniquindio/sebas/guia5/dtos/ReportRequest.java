package com.uniquindio.sebas.guia5.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uniquindio.sebas.guia5.doamin.Comentario;
import com.uniquindio.sebas.guia5.doamin.Imagen;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

/**
 * Clase que representa la peticion de un reporte
 * @param title
 * @param contenido
 * @param image
 * @param latitud
 * @param longitud
 * @param categoriasdIds
 * @param fechaSuceso
 */
public record ReportRequest(
                            @NotBlank(message = "el titulo es requerido")
                            @Size(min = 20,max = 150,message = "el titulo debe tener entre 20 y 150 caracteres")
                            String title,
                            @NotBlank(message = "el contenido es requerido")
                            @Size(max = 1000, message = "el contenido del reporte no debe exeder los 1000 caracteres")
                            String contenido,
                            @NotNull(message = "la imagen es requerida")
                            @URL(message = "la imagen debe ser una URL valida")
                            String image,
                            @NotNull(message = "la latitud es requerida")
                            @DecimalMin(value = "-90",inclusive = true, message = "la latitud debe ser mayor a -90")
                            @DecimalMax(value = "90",inclusive = true, message = "la latitud debe ser menor a 90")
                            String latitud,
                            @NotNull(message = "la longitud es requerida")
                            @DecimalMin(value = "-180",inclusive = true, message = "la latitud debe ser mayor a -180")
                            @DecimalMax(value = "180",inclusive = true, message = "la latitud debe ser menor a 180")
                            String longitud,
                            @NotEmpty(message = "el arreglo de Ids de categorias es requerido")
                            @Size(min = 1, message = "el arreglo de categorias es requrido con al menos 1 elemento")
                            List<Long> categoriasdIds,
                            @NotBlank(message = "la fecha del suceso es requerida")
                            @PastOrPresent(message = "La Fecha no puede ser furura. no tiene sentido")
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                            @DateTimeFormat(pattern = "yyyy-MM-dd")
                            String fechaSuceso,
                            @NotEmpty(message = "los comentarios son requeridos")
                            List<Comentario> listaComentarios

) {
}
