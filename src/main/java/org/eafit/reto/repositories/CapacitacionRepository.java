package org.eafit.reto.repositories;

import org.eafit.reto.models.Capacitacion;
import org.eafit.reto.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapacitacionRepository extends JpaRepository<Capacitacion, Integer> {
}
