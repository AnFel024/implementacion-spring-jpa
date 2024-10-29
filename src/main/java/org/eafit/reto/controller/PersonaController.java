package org.eafit.reto.controller;

import lombok.RequiredArgsConstructor;
import org.eafit.reto.models.Persona;
import org.eafit.reto.services.PersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {
    private final PersonaService personaService;

    @GetMapping("/list")
    public List<Persona> listarPersonas() {
        return personaService.findAll();
    }

    @PostMapping("/update")
    public Persona crearPersona(@RequestBody Persona persona) {
        return personaService.up(persona);
    }

    @PutMapping("/create")
    public Persona crearPersona2(@RequestBody Persona persona) {
        return personaService.create(persona);
    }

    @GetMapping("/get/{id}")
    public Persona obtenerPersona(@PathVariable Long id) {
        return personaService.findByCedula(id);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaService.delete(id);
    }

}
