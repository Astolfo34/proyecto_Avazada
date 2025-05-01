package com.uniquindio.sebas.guia5.doamin;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("categorias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria {
    @Id
    @EqualsAndHashCode.Include
    private String id;
    private String name;
    private String description;
}
