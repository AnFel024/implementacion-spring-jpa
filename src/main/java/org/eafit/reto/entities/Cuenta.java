package org.eafit.reto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String numeroCuenta;
    private String banco;

    @OneToOne
    @JoinTable(name = "cuenta_persona",
    joinColumns = @JoinColumn(name = "id"),
    inverseJoinColumns = @JoinColumn(name = "cedula"))
    private PersonaPostgres personaPostgres;
}
