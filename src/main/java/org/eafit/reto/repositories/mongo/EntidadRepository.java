package org.eafit.reto.repositories.mongo;

import org.eafit.reto.models.mongo.Entidad;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntidadRepository extends MongoRepository<Entidad, String> {
    Optional<Entidad> findByIdentificador(String nombre);
}