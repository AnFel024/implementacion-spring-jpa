package org.eafit.reto.services;

import org.eafit.reto.entities.mongo.MongoPersona;
import org.eafit.reto.mappers.interfaces.PersonaMapper;
import org.eafit.reto.models.Persona;
import org.eafit.reto.repositories.mongo.MongoPersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MongoPersonaService {

    //private final PersonaRepository personaRepository;
    private final MongoPersonaRepository personaRepository;
    private final PersonaMapper mapper;

    public MongoPersonaService(MongoPersonaRepository personaRepository, PersonaMapper mapper) {
        this.personaRepository = personaRepository;
        this.mapper = mapper;
    }
    //private final MongoPersonaRepository personaRepository;

    public Persona create(Persona persona) {
        MongoPersona personaPostgres =
                mapper.mapPersonaToMongoPersona(persona);
        //personaPostgres.setCreated_at(LocalDateTime.now());
        //personaPostgres.setUpdated_at(LocalDateTime.now());
        Persona persona1 =
                mapper.mapMongoPersonaToPersona(
                        personaRepository.save(personaPostgres)
                );
        System.out.println("Entidad creada");
        return persona1;
    }

    public List<Persona> findAll() {
        return mapper.mapPersonaMongoListToPersonaModelList(personaRepository.findAll());
    }

    public List<Persona> findByNombre(String nombre) {
        return mapper.mapPersonaPostgresListToPersonaModelList(personaRepository.findByNombre(nombre).orElse(List.of()));
    }

    public Persona up(Persona persona) {
        MongoPersona personaPostgres = mapper.mapPersonaToMongoPersona(persona);
        //personaPostgres.setUpdated_at(LocalDateTime.now());
        Persona persona1 = mapper.mapMongoPersonaToPersona(
                personaRepository.save(personaPostgres));
        System.out.println("Entidad actualizada");
        return persona1;
    }

    public Persona findByCedula(Long cedula) {
        Optional<MongoPersona> optionalPersona =
                personaRepository.findById(cedula);
        if (optionalPersona.isEmpty()) {
            System.out.println("La persona con cedula "
                    + cedula + " no existe");
            return null;
        }
        return mapper.mapMongoPersonaToPersona(optionalPersona.get());
    }

    public void delete(Long id) {
        personaRepository.deleteById(id);
    }
}
