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
    private String titulo;

    @NotNull(message = "Las categorías no pueden ser nulas")
    private List<Categoria> listaCategorias;

    @NotNull(message = "La ubicación no puede ser nula")
    private Location ubicacion;

    private Imagen imagenReporte;

    private LocalDateTime fechaCreacion;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    private String userId;

    @NotNull(message = "La fecha del incidente no puede ser nula")
    private LocalDateTime fechaIncidente;

    @NotNull(message = "El estado del reporte no puede ser nulo")
    private EstadoReporte estadoReporte;

    private List<Comentario> listaComentarios;

    private int contadorDeImportancia;
}
