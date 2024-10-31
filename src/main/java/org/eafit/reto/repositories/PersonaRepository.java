package org.eafit.reto.repositories;

import org.eafit.reto.entities.PersonaPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaPostgres, Long> {

    Optional<List<PersonaPostgres>> findByNombre(String nombre);

    /*
    Optional<List<Persona>> findByNombreIgnoreCaseAndAndCedula(String nombre, Long cedula);

    @Query("with ventas as (" +
            "select p.cedula, sum(v.valor) as total from persona p " +
            "join venta v on p.cedula = v.cedula group by p.cedula) " +
            "select p.* from persona p join ventas v on p.cedula = " +
            "v.cedula where p.cedula = ?1")
    Optional<Persona> findAllVentasByDepartamento(Long cedula);*/
}
