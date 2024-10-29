package org.eafit.reto.controller.mongo;

import org.eafit.reto.models.mongo.Entidad;
import org.eafit.reto.services.mongo.EntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mongo/personas")
public class EntidadController {

    @Autowired
    private EntidadService entidadService;

    @PostMapping
    public Entidad create(@RequestBody Entidad entidad) {
        return entidadService.create(entidad);
    }

    @GetMapping
    public List<Entidad> findAll() {
        return entidadService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Entidad> findById(@PathVariable String id) {
        return entidadService.findById(id);
    }

    @GetMapping("/nombre")
    public Optional<Entidad> findByNombre(@RequestParam String nombre) {
        return entidadService.findByIdentificador(nombre);
    }
}