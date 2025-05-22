package com.uniquindio.sebas.guia5.dtos;

import com.uniquindio.sebas.guia5.doamin.Categoria;
import com.uniquindio.sebas.guia5.doamin.Comentario;
import com.uniquindio.sebas.guia5.doamin.EstadoReporte;
import com.uniquindio.sebas.guia5.doamin.Imagen;
import com.uniquindio.sebas.guia5.doamin.Location;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReporteDTO {

    private String id;

    @NotBlank(message = "El título no puede estar vacío")
    private String title;

    @NotNull(message = "Las categorías no pueden ser nulas")
    private List<Categoria> categories;

    @NotNull(message = "La ubicación no puede ser nula")
    private Location location;

    private String imageUrl;

    private LocalDateTime occurrenceDate;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String content;

    private String userId;

    @NotNull(message = "La fecha del incidente no puede ser nula")
    private LocalDateTime createdAt;

    @NotNull(message = "El estado del reporte no puede ser nulo")
    private EstadoReporte status;

    private List<Comentario> listComments;

    private int importanceCount;
}
