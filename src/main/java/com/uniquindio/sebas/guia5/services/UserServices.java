package com.uniquindio.sebas.guia5.services;

import com.uniquindio.sebas.guia5.doamin.User;
import com.uniquindio.sebas.guia5.dtos.UserRegistration;
import com.uniquindio.sebas.guia5.dtos.UserResponse;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

//CADA UNA DE ESTAS INTERFACES DEBE SER IMPLEMENTADA EN UNA CLASE
// QUE EJECUTE LAS ASIGNACIONES DEFINIDAS AQUI

@Service
public interface UserServices {
    /**
     * CLASE DE SERVICIOS DE USUARIO, LA CUAL USARA LOS MAPPERS PARA TRANSFORMAR LOS DATOS QUE LLEGAN DTO
     * Y USARLOS CON LAS ENTIDADES PARA EJECUTAR REGISTROS EN LA BASE DE DATOS HACIENDO USO DE LOS REPOSITORIOS
     * DE USUARIO, EN ESTA SECCION DEBE IR LA LOGICA DE NEGOCIO PARA ESTE OBJETO Y ESTE DEBE COMUNICARSE
     * CON LOS CONTROLAD0ORES PARA SER USADOS EN LAS CAPAS EXTERNAS COMO FRONTEND
     */

    UserResponse createUser(UserRegistration user);// we gonna create a user catching a DTO that are requesting , and return a DTO that are resolving
    Optional<UserResponse> getUser(String id);     // look an user by id , are optional if the user don't exist
    Optional<UserResponse> updateUser(String id, UserRegistration request);
    boolean deleteUser(String id);

    boolean activateUser(@NotBlank(message = "El código de activación es requerido y el email") String e, String s);

    boolean estaActivo(String email);

    UserDetails loadUserByUsername(String email);
    Optional<User>findUserByEmail(String email);

    Optional<User>findUserById(String id);
/*//------------------------clavijo-------------------------------------
    Optional<UserResponse> loginUser(String email, String password);*/
}
