package org.eafit.reto.repositories;

import org.eafit.reto.models.Departamento;
import org.eafit.reto.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

    Optional<List<Persona>> findByNombre(String nombre);
}
