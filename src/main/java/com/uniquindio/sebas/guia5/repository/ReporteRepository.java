package com.uniquindio.sebas.guia5.repository;

import com.uniquindio.sebas.guia5.doamin.Reporte;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define los métodos de acceso a datos para la entidad Reporte.
 * Extiende de MongoRepository para proporcionar operaciones CRUD y consultas personalizadas.
 */
@Repository
public interface ReporteRepository extends MongoRepository<Reporte, String> {

    List<Reporte> findByUserId(String userId);

    boolean existsByTitleAndUserId(String title, String userId);
}
