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



@Document("reportes")
@NoArgsConstructor     // sometimes isn't sufficient with only builder constructor, is necessary other patterns
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Reporte {

    @EqualsAndHashCode.Include
    @Id
    private String id;
    private String titulo;
    @Field("lista categorias")  //nombre específico en el mongo
    @DBRef
    private List<Categoria> listaCategorias;
    private Location ubicacion;
    private Imagen imagenReporte;
    private LocalDateTime fechaCreacion;
    private String descripcion;
    private ObjectId userId;
    private DateTimeFormat fechaIncidente;
    private EstadoReporte estadoReporte;
    @Field("lista Comentarios")
    @DBRef
    private List<Comentario>listaComentarios;
    private int contadorDeImportancia;

}
