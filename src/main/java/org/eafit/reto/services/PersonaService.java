package org.eafit.reto.services;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.eafit.reto.models.Persona;
import org.eafit.reto.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class PersonaService {

    private final PersonaRepository personaRepository;

    public Persona create(Persona persona) {
        Persona persona1 = personaRepository.save(persona);
        System.out.println("Entidad creada");
        return persona1;
    }

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Persona findById(Long id) {
        Optional<Persona> optionalPersona = personaRepository.findById(id);
        if (optionalPersona.isEmpty()) {
            System.out.println("La persona con id " + id + " no existe");
            return null;
        }
        return optionalPersona.get();
    }
}
