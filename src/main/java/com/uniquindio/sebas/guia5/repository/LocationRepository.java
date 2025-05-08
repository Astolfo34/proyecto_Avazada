package com.uniquindio.sebas.guia5.repository;

import com.uniquindio.sebas.guia5.doamin.Location;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<Location, String> {
}
