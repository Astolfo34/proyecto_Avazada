package com.uniquindio.sebas.guia5.doamin;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

//ADD METHODS FOR ADMINISTRATION OF THE CLASS USING LOMBOK DEPENDENCIES
@Entity
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
    @Column(nullable = false, length = 100)
    private String fullName;

    @Id                                                   //used to change id in form auto-incremental in BD
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //but id have been in type Long, because GV works with numeric camps
    private String id;

    @Column(nullable = false, length = 150, unique = true)
    private String email;

    private String password;
    private LocalDate dateBirth;
    private Rol rolUser;
    private UserStatus stateUser;  //IMPLEMENTATION OF CLAS FOR STATE OF USERS
}

