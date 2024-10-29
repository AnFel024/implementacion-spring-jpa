package org.eafit.reto.repositories;

import org.eafit.reto.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    Optional<Departamento> findByPersonas_CedulaAndId(Long personaId, Integer departamentoId);
    // Departamento updateDepartamentoByPersonas_CedulaAndId(Long personaId, Integer departamentoId);
}
