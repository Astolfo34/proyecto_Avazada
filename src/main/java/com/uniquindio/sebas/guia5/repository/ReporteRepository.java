package com.uniquindio.sebas.guia5.repository;

import com.uniquindio.sebas.guia5.doamin.EstadoReporte;
import com.uniquindio.sebas.guia5.doamin.Reporte;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfaz que define los métodos de acceso a datos para la entidad Reporte.
 * Extiende de MongoRepository para proporcionar operaciones CRUD y consultas personalizadas.
 */
@Repository
public interface ReporteRepository extends MongoRepository<Reporte, String> {

    List<Reporte> findByUserId(ObjectId userId);


}
