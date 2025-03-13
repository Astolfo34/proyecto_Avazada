package com.uniquindio.sebas.guia5.repository;

import com.uniquindio.sebas.guia5.doamin.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * ESTA INTERFAZ ME PERMITE INTERACTUAR CON LA BASE DE DATOS USANDO LA ENTIDAD DE USUARIO
 * PERMITE REALIZAR OPERACIONES CRUD SOBRE LA BASE DE DATOS SIN LA NECESIDAD DE REALIZAR CONSULTAS SQL
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email); // a method for look using an email
}

