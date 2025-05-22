package com.uniquindio.sebas.guia5.repository;

import com.uniquindio.sebas.guia5.doamin.Notificacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificacionRepository extends MongoRepository<Notificacion, String> {

    /**
     * Método para encontrar una notificación por su ID.
     *
     * @param id el ID de la notificación a buscar
     * @return la notificación encontrada, o null si no se encuentra
     */
    Optional<Notificacion> findById(String id);

    /**
     * Método para eliminar una notificación por su ID.
     *
     * @param id el ID de la notificación a eliminar
     */
    void deleteById(String id);
}
