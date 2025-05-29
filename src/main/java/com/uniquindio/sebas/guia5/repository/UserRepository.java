package com.uniquindio.sebas.guia5.repository;

import com.uniquindio.sebas.guia5.doamin.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * ESTA INTERFAZ ME PERMITE INTERACTUAR CON LA BASE DE DATOS USANDO LA ENTIDAD DE USUARIO
 * PERMITE REALIZAR OPERACIONES CRUD SOBRE LA BASE DE DATOS SIN LA NECESIDAD DE REALIZAR CONSULTAS SQL
 */
public interface UserRepository extends MongoRepository<User, String> { // Cambio Long por String si usas MongoDB
    Optional<User> findUserByEmail(String email); // Método para buscar por email
    Optional<User> findUserByActivationCode(String activationCode);

    /*List<User> findByRol(String admin);*/
}

