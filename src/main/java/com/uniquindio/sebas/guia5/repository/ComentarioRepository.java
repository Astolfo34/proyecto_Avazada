package com.uniquindio.sebas.guia5.repository;

import com.uniquindio.sebas.guia5.doamin.Comentario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComentarioRepository extends MongoRepository<Comentario, String> {
}
