package com.uniquindio.sebas.guia5.doamin;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("imagenes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Imagen {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    private String ruta;
    private String nombre;
}

