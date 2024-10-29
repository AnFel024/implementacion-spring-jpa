package org.eafit.reto.services;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.eafit.reto.models.Persona;
import org.eafit.reto.repositories.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class PersonaService {

    private final PersonaRepository personaRepository;
    //private final MongoPersonaRepository personaRepository;

    public Persona create(Persona persona) {
        Persona persona1 = personaRepository.save(persona);
        System.out.println("Entidad creada");
        return persona1;
    }

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public List<Persona> findByNombre(String nombre) {
        return personaRepository.findByNombre(nombre).orElse(List.of());
    }

    public Persona up(Persona persona) {
        Persona persona1 = personaRepository.save(persona);
        System.out.println("Entidad actualizada");
        return persona1;
    }

    public Persona findByCedula(Long cedula) {
        Optional<Persona> optionalPersona =
                personaRepository.findById(cedula);
        if (optionalPersona.isEmpty()) {
            System.out.println("La persona con cedula "
                    + cedula + " no existe");
            return null;
        }
        return optionalPersona.get();
    }

    public void delete(Long id) {
        personaRepository.deleteById(id);
    }
}
