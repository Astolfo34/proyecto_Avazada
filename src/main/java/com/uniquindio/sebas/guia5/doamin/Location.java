package com.uniquindio.sebas.guia5.doamin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ubicaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    private String id;
    private double latitud;
    private double longitud;
}
