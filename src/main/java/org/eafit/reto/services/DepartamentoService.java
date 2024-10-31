package org.eafit.reto.services;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.eafit.reto.entities.Departamento;
import org.eafit.reto.mappers.interfaces.PersonaMapper;
import org.eafit.reto.models.Persona;
import org.eafit.reto.repositories.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    private final PersonaService personaService;
    private final PersonaMapper personaMapper;

    public Departamento create(Departamento Departamento) {
        Departamento Departamento1 = departamentoRepository.save(Departamento);
        System.out.println("Entidad creada");
        return Departamento1;
    }

    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }

    public Departamento update(Departamento departamento) {
        Departamento Departamento1 = departamentoRepository.save(departamento);
        System.out.println("Entidad actualizada");
        return Departamento1;
    }

    public Departamento findById(Integer id) {
        Optional<Departamento> optionalDepartamento = departamentoRepository.findById(id);
        if (optionalDepartamento.isEmpty()) {
            System.out.println("La Departamento con id " + id + " no existe");
            return null;
        }
        return optionalDepartamento.get();
    }

    public Departamento findByCedulaAndDepartamentoId(Long personaId, Integer departamentoId) {
        Optional<Departamento> optionalPersona = departamentoRepository.findByPersonas_CedulaAndId(personaId, departamentoId);
        if (optionalPersona.isEmpty()) {
            System.out.println("La persona con cedula " + personaId + " no existe en el departamento con id " + departamentoId);
            return null;
        }
        return optionalPersona.get();
    }

    /*
    Pasos para actualizar una persona en un departamento
    * 1. Obtener informacion de la persona con el id personaCedula
    * 2. Obtener informacion del departamento con el id departamentoId
    * 3. Del set de personas, agregar la persona
    * obtenida en el paso 1 y guardarla en
    * el set de personas para ese departamento
    * 4. Actualizar el departamento
    * */

    public void addPersona(Long personaCedula,
                           Integer departamentoId) {
        Persona personaByCedula =
                personaService.findByCedula(personaCedula);
        if (personaByCedula == null) {
            System.out.println("La persona con cedula "
                    + personaCedula + " no existe");
            throw new RuntimeException("La persona con cedula "
                    + personaCedula + " no existe");
        }
        Departamento departamento = findById(departamentoId);
        if (departamento == null) {
            System.out.println("El departamento con id "
                    + departamentoId + " no existe");
            throw new RuntimeException("La persona con cedula "
                    + personaCedula + " no existe");
        }
        departamento.getPersonas().add(
                personaMapper.mapPersonaModelToPersonaPostgres(personaByCedula));
        update(departamento);
        //departamentoRepository.updateDepartamentoByPersonas_CedulaAndId(personaCedula, departamentoId);
    }
}
