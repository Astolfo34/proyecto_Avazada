package com.uniquindio.sebas.guia5.repository;

import com.uniquindio.sebas.guia5.doamin.Imagen;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImagenRepository extends MongoRepository<Imagen, String> {
}
