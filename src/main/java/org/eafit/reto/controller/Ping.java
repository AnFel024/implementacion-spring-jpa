package org.eafit.reto.controller;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.eafit.reto.models.Capacitacion;
import org.eafit.reto.models.Cuenta;
import org.eafit.reto.models.Departamento;
import org.eafit.reto.models.Persona;
import org.eafit.reto.services.CapacitacionService;
import org.eafit.reto.services.CuentaService;
import org.eafit.reto.services.DepartamentoService;
import org.eafit.reto.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class Ping {

    private final PersonaService personaService;

    private final DepartamentoService departamentoService;

    private final CuentaService cuentaService;

    private final CapacitacionService capacitacionService;

    @GetMapping("/ping")
    public String ping() {

        // Repositorios


        // Dominios (registros)
        Persona persona = new Persona();
        persona.setNombre("Juana Leon");
        persona.setCedula(1234987L);
        Persona persona2 = Persona.builder()
                .nombre("Andres Morales")
                .cedula(123L)
                .build();
        Persona persona3 = Persona.builder()
                .nombre("Ares Morals")
                .cedula(124L)
                .build();
        Persona persona4 = Persona.builder()
                .nombre("ndres Moraes")
                .cedula(125L)
                .build();
        /* persona3 = Persona.builder()
                .nombre("Andres Morales")
                .cedula(123L)
                .build();*/
        Departamento departamento = new Departamento();
        departamento.setNombre("Contabilidad");
        Departamento departamento2 = new Departamento();
        departamento2.setNombre("Tesoreria");
        Departamento departamento3 = new Departamento();
        departamento3.setNombre("Sistemas");

        Cuenta cuenta = Cuenta.builder()
                .banco("Banco Santander")
                .numeroCuenta("123BS")
                .build();

        Cuenta cuenta2 = Cuenta.builder()
                .banco("Bancolombia")
                .numeroCuenta("123BC")
                .build();

        Capacitacion capacitacion = Capacitacion.builder()
                .horaInicio(LocalTime.of(17, 0, 0))
                .horaFin(LocalTime.of(18, 0, 0))
                .nombre("Java 1")
                .build();

        Capacitacion capacitacion2 = Capacitacion.builder()
                .horaInicio(LocalTime.of(18, 0, 0))
                .horaFin(LocalTime.of(19, 0, 0))
                .nombre("SQL Avanzado")
                .build();

        // Almacena las personas en la base de datos
        personaService.create(persona);
        personaService.create(persona2);
        personaService.create(persona3);
        personaService.create(persona4);

        // Almacena el departamento en la base
        departamento.getPersonas().add(persona);
        departamento.getPersonas().add(persona2);
        departamentoService.create(departamento);

        departamento2.getPersonas().add(persona3);
        departamentoService.create(departamento2);

        departamento3.getPersonas().add(persona4);
        departamentoService.create(departamento3);

        // Almacena
        cuentaService.create(cuenta);
        cuentaService.create(cuenta2);
		/*capacitacionService.create(capacitacion);
		capacitacionService.create(capacitacion2);*/

        // Metodos para listar

        for ( Departamento depto : departamentoService.findAll()) {
            System.out.println("Para el departamento " + depto.getNombre() + " trabajan las personas:");
            depto.getPersonas()
                    .forEach(System.out::println);
        }
        return "ping";
    }
}