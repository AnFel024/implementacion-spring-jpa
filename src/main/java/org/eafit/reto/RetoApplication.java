package org.eafit.reto;

import org.eafit.reto.models.Capacitacion;
import org.eafit.reto.models.Cuenta;
import org.eafit.reto.models.Departamento;
import org.eafit.reto.models.Persona;
import org.eafit.reto.services.CapacitacionService;
import org.eafit.reto.services.CuentaService;
import org.eafit.reto.services.DepartamentoService;
import org.eafit.reto.services.PersonaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalTime;

@SpringBootApplication
public class RetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetoApplication.class, args);


	}
}
