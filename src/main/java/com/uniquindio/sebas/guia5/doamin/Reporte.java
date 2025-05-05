package com.uniquindio.sebas.guia5.doamin;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Document("reportes")  // Cambia la colección a 'reportes' en Mongo
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Reporte {

    @Id
    @EqualsAndHashCode.Include
    private String id;
    private String titulo;

    @Field("lista categorias")
    @DBRef
    private List<Categoria> listaCategorias;

    private Location ubicacion;

    private Imagen imagenReporte;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime fechaCreacion;
    private String descripcion;
    private ObjectId userId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime fechaIncidente;

    private EstadoReporte estadoReporte;
    @Field("lista Comentarios")
    @DBRef
    private List<Comentario> listaComentarios;

    private int contadorDeImportancia;

}
