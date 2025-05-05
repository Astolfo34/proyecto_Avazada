package com.uniquindio.sebas.guia5.repository;

import com.uniquindio.sebas.guia5.doamin.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {
}
