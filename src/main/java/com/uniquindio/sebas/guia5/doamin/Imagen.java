package com.uniquindio.sebas.guia5.doamin;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("imagenes")
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Imagen {

    @Id
    @EqualsAndHashCode.Include
    private String id;
    private String ruta;
    private String nombre;

}
