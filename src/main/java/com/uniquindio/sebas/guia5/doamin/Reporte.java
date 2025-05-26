package com.uniquindio.sebas.guia5.doamin;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
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
    private String title;

    @Field("lista categorias")
    //@DBRef  para pruebas sin datos preexistentes, cuando se implemente hay que tomar medidas de validacion de datos ya existentes o lanzara error
    private List<Categoria> categories;

    private Location location;

    private String imageUrl;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate createdAt;
    private String content;
    private String userId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate occurrenceDate;

    private EstadoReporte status;
    @Field("lista Comentarios")
    //@DBRef
    private List<Comentario> listComments;

    private int importanceCount;

}
