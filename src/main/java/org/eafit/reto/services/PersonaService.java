package org.eafit.reto.services;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.eafit.reto.entities.PersonaPostgres;
import org.eafit.reto.mappers.interfaces.PersonaMapper;
import org.eafit.reto.models.Persona;
import org.eafit.reto.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;
    private final PersonaMapper mapper;

    public PersonaService(PersonaRepository personaRepository, PersonaMapper mapper) {
        this.personaRepository = personaRepository;
        this.mapper = mapper;
    }
    //private final MongoPersonaRepository personaRepository;

    public Persona create(Persona persona) {
        PersonaPostgres personaPostgres =
                mapper.mapPersonaModelToPersonaPostgres(persona);
        personaPostgres.setCreated_at(LocalDateTime.now());
        personaPostgres.setUpdated_at(LocalDateTime.now());
        Persona persona1 =
                mapper.mapPersonaPostgresToPersonaModel(
                        personaRepository.save(personaPostgres)
                );
        System.out.println("Entidad creada");
        return persona1;
    }

    public List<Persona> findAll() {
        return mapper.mapPersonaPostgresListToPersonaModelList(personaRepository.findAll());
    }

    public List<Persona> findByNombre(String nombre) {
        return mapper.mapPersonaPostgresListToPersonaModelList(personaRepository.findByNombre(nombre).orElse(List.of()));
    }

    public Persona up(Persona persona) {
        PersonaPostgres personaPostgres = mapper.mapPersonaModelToPersonaPostgres(persona);
        personaPostgres.setUpdated_at(LocalDateTime.now());
        Persona persona1 = mapper.mapPersonaPostgresToPersonaModel(
                personaRepository.save(personaPostgres));
        System.out.println("Entidad actualizada");
        return persona1;
    }

    public Persona findByCedula(Long cedula) {
        Optional<PersonaPostgres> optionalPersona =
                personaRepository.findById(cedula);
        if (optionalPersona.isEmpty()) {
            System.out.println("La persona con cedula "
                    + cedula + " no existe");
            return null;
        }
        return mapper.mapPersonaPostgresToPersonaModel(optionalPersona.get());
    }

    public void delete(Long id) {
        personaRepository.deleteById(id);
    }
}
