package org.eafit.reto.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Capacitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    @ManyToMany
    @JoinTable( name = "capacitacion_persona",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "cedula")
    )
    private Set<Persona> persona;
    /*
    @OneToOne
    @OneToMany
    @ManyToOne  <---
    @ManyToMany
     */
}
