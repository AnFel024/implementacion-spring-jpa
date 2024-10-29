package org.eafit.reto.services;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.eafit.reto.models.Departamento;
import org.eafit.reto.models.Persona;
import org.eafit.reto.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public Departamento create(Departamento Departamento) {
        Departamento Departamento1 = departamentoRepository.save(Departamento);
        System.out.println("Entidad creada");
        return Departamento1;
    }

    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }

    public Departamento up(Departamento Departamento) {
        Departamento Departamento1 = departamentoRepository.save(Departamento);
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
}
