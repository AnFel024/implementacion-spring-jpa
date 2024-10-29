package org.eafit.reto.repositories;

import org.eafit.reto.models.Departamento;
import org.eafit.reto.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    Optional<Departamento> findByPersonas_CedulaAndId(Long personaId, Integer departamentoId);
}
