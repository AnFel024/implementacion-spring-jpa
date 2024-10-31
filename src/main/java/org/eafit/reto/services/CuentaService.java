package org.eafit.reto.services;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.eafit.reto.entities.Cuenta;
import org.eafit.reto.repositories.CuentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class CuentaService {

    private final CuentaRepository cuentaRepository;

    public Cuenta create(Cuenta Cuenta) {
        Cuenta cuenta1 = cuentaRepository.save(Cuenta);
        System.out.println("Entidad creada");
        return cuenta1;
    }

    public List<Cuenta> findAll() {
        return cuentaRepository.findAll();
    }

    public Cuenta findById(UUID id) {
        Optional<Cuenta> optionalCuenta = cuentaRepository.findById(id);
        if (optionalCuenta.isEmpty()) {
            System.out.println("La Cuenta con id " + id + " no existe");
            return null;
        }
        return optionalCuenta.get();
    }
}
