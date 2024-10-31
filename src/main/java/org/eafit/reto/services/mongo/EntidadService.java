package org.eafit.reto.services.mongo;

import org.eafit.reto.entities.mongo.Entidad;
import org.eafit.reto.repositories.mongo.EntidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EntidadService {
    @Autowired
    private EntidadRepository entidadRepository;

    public Entidad create(Entidad entidad) {
        return entidadRepository.insert(entidad);
    }

    public List<Entidad> findAll() {
        return entidadRepository.findAll();
    }

    public Optional<Entidad> findByIdentificador(String nombre) {
        return entidadRepository.findByIdentificador(nombre);
    }

    public Optional<Entidad> findById(String id) {
        return entidadRepository.findById(id);
    }
}