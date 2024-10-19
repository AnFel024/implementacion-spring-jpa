package org.eafit.reto.services;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.eafit.reto.models.Capacitacion;
import org.eafit.reto.repositories.CapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class CapacitacionService {

    private final CapacitacionRepository capacitacionRepository;

    public Capacitacion create(Capacitacion Capacitacion) {
        Capacitacion capacitacion1 = capacitacionRepository.save(Capacitacion);
        System.out.println("Entidad creada");
        return capacitacion1;
    }

    public List<Capacitacion> findAll() {
        return capacitacionRepository.findAll();
    }

    public Capacitacion findById(Integer id) {
        Optional<Capacitacion> optionalCapacitacion = capacitacionRepository.findById(id);
        if (optionalCapacitacion.isEmpty()) {
            System.out.println("La Capacitacion con id " + id + " no existe");
            return null;
        }
        return optionalCapacitacion.get();
    }
}
