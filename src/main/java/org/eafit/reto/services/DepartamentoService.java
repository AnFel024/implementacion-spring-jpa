package org.eafit.reto.services;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.eafit.reto.models.Departamento;
import org.eafit.reto.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Departamento findById(Integer id) {
        Optional<Departamento> optionalDepartamento = departamentoRepository.findById(id);
        if (optionalDepartamento.isEmpty()) {
            System.out.println("La Departamento con id " + id + " no existe");
            return null;
        }
        return optionalDepartamento.get();
    }
}
