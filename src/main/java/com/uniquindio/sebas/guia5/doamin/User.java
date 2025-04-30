package com.uniquindio.sebas.guia5.doamin;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDate;
import java.util.List;

//ADD METHODS FOR ADMINISTRATION OF THE CLASS USING LOMBOK DEPENDENCIES

@Table(name = "users")
@NoArgsConstructor     // sometimes isn't sufficient with only builder constructor, is necessary other patterns
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
    @Id                                                   //used to change id in form auto-incremental in BD
    //@GeneratedValue(strategy = GenerationType.IDENTITY)  //but id have been in type Long, because GV works with numeric camps
    private String id;

    @Column(nullable = false, length = 150, unique = true)
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

