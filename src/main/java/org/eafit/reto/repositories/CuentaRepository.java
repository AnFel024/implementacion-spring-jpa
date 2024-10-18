package org.eafit.reto.repositories;

import org.eafit.reto.models.Cuenta;
import org.eafit.reto.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, UUID> {
}
