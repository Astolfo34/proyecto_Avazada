package com.uniquindio.sebas.guia5.doamin;

import com.uniquindio.sebas.guia5.doamin.Rol;
import com.uniquindio.sebas.guia5.doamin.UserStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.util.List;

/**
 * ENTIDAD DEFINIDA COMO LA ESTRUCTURA PARA LOS REGISTROS DE LOS OBJETOS
 * EN LA BASE DE DATOS, DE ESTA MANERA RELACIONARSE CON LOS MAPPERS QUE TRANSFORMARAN
 * LA INFORMACION EN OBJETOS DTO.
 */

// ADD METHODS FOR ADMINISTRATION OF THE CLASS USING LOMBOK DEPENDENCIES
@Document(collection = "users")  // Indica que esta clase se mapeará a la colección 'users' en MongoDB
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {

    /**
     * ENTIDAD DEFINIDA COMO LA ESTRUCTURA PARA LOS REGISTROS DE LOS OBJETOS
     * EN LA BASE DE DATOS, DE ESTA MANERA RELACIONARSE CON LOS MAPPERS QUE TRANSFORMARAN
     * LA INFORMACION EN OBJETOS DTO.
     */

    // PRINCIPALS ATTRIBUTES  OF THE CLASS
    private String fullName;

    @Id // Mongo usa este @Id para identificar documentos
    private String id;

    private String email;
    private String password;
    private LocalDate dateBirth;
    private Rol rolUser;
    private UserStatus stateUser;  //IMPLEMENTATION OF CLAS FOR STATE OF USERS
    @DBRef                         //referencia con una tabla externa de la BD
    private List<Reporte> lista_Reportes;
    private List<Notificacion>lista_notificaciones;
    private String direccion;
    private String telefono;
    private String imagenPerfil;
    // se asume que se manejara la direccion de la ciudad por logica de ubicacion
}

