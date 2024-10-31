package org.eafit.reto.controller;

import lombok.RequiredArgsConstructor;
import org.eafit.reto.contracts.request.PersonaRequest;
import org.eafit.reto.contracts.responses.PersonaResponse;
import org.eafit.reto.mappers.interfaces.PersonaMapper;
import org.eafit.reto.models.Persona;
import org.eafit.reto.services.PersonaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {
    private final PersonaService personaService;
    private final PersonaMapper personaMapper;

    @GetMapping("/list")
    public List<PersonaResponse> listarPersonas() {
        return personaMapper.mapPersonaModelListToPersonaResponseList(personaService.findAll());
    }

    @PostMapping("/update")
    public PersonaResponse crearPersona(@RequestBody PersonaRequest personaRequest) {
        return
                personaMapper.mapPersonaModelToPersonaResponse(
                        personaService.up(
                                personaMapper.mapPersonaModelToPersonaRequest(
                                        personaRequest)));
    }

    @PutMapping("/create")
    public PersonaResponse crearPersona2(@RequestBody PersonaRequest personaPostgres) {
        Persona persona = personaMapper.mapPersonaModelToPersonaRequest(personaPostgres);
        Persona persona1 = personaService.create(persona);
        return personaMapper.mapPersonaModelToPersonaResponse(persona1);
    }

    @GetMapping("/get/{id}")
    public PersonaResponse obtenerPersona(@PathVariable Long id) {
        return personaMapper.mapPersonaModelToPersonaResponse(personaService.findByCedula(id));
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarPersona(@PathVariable Long id) {
        personaService.delete(id);
    }

}
