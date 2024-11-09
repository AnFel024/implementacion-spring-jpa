package org.eafit.reto.repositories;

import org.eafit.reto.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    Optional<Departamento> findByPersonas_CedulaAndId(Long personaId, Integer departamentoId);
}
