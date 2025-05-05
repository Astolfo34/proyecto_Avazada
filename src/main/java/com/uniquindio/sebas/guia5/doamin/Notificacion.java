package com.uniquindio.sebas.guia5.doamin;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document("notificaciones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Notificacion {

    @Id
    private String id;
    private TipoNotificacion tipo;
    private String mensaje;
    private DateTimeFormat fechaCreada;
    private Boolean estadoLeido;
}
