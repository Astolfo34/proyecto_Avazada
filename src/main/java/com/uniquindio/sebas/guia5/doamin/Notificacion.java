package com.uniquindio.sebas.guia5.doamin;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Document("notificaciones")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Notificacion {

    @Id
    @EqualsAndHashCode.Include
    private String id;

    private TipoNotificacion tipo;
    private String mensaje;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime fechaCreada;

    private Boolean estadoLeido;
}
