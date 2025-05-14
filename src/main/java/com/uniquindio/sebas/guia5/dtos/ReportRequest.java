package com.uniquindio.sebas.guia5.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.uniquindio.sebas.guia5.doamin.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

/**
 * Clase que representa la peticion de un reporte
 * @param title
 * @param contenido
 * @param image
 * @param categories
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
                            @NotNull(message = "la ubicacion es requerida")
                            Location location,
                            @NotEmpty(message = "el arreglo de Ids de categorias es requerido")
                            @Size(min = 1, message = "el arreglo de categorias es requrido con al menos 1 elemento")
                            List<Categoria> categories,
                            @NotBlank(message = "la fecha del suceso es requerida")
                            @PastOrPresent(message = "La Fecha no puede ser furura. no tiene sentido")
                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                            @DateTimeFormat(pattern = "yyyy-MM-dd")
                            String fechaSuceso,
                            List<Comentario> listaComentarios,
                            String userId_creador,
                            Integer importanceCount,
                            EstadoReporte status

) {
}
