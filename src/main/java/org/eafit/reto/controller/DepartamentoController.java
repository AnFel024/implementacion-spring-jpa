package org.eafit.reto.controller;

import lombok.RequiredArgsConstructor;
import org.eafit.reto.contracts.PersonaToDepartamentoContract;
import org.eafit.reto.models.Departamento;
import org.eafit.reto.services.DepartamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departamento")
@RequiredArgsConstructor
public class DepartamentoController {
    private final DepartamentoService departamentoService;

    @GetMapping("/list")
    public List<Departamento> listarDepartamentos() {
        return departamentoService.findAll();
    }

    @PutMapping("/create")
    public Departamento crearDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.create(departamento);
    }

    @PostMapping("/update")
    public Departamento actualizarDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.update(departamento);
    }

    @GetMapping("/get/{id}")
    public Departamento obtenerDepartamento(@PathVariable Integer id) {
        return departamentoService.findById(id);
    }

    @GetMapping("/get/{departamentoId}/persona/{personaId}")
    public Departamento obtenerDepartamento(@PathVariable Integer departamentoId, @PathVariable Long personaId) {
        return departamentoService.findByCedulaAndDepartamentoId(personaId, departamentoId);
    }

    @PostMapping("/add/persona")
    public ResponseEntity<?> agregarPersona(
            @RequestBody PersonaToDepartamentoContract
                    personaToDepartamentoContract) {
        departamentoService.addPersona(
                personaToDepartamentoContract.getPersonaCedula(),
                personaToDepartamentoContract.getDepartamentoId());
        return ResponseEntity.ok().body(
                Map.of("message",
                        "Persona agregada al departamento"));
    }
}
