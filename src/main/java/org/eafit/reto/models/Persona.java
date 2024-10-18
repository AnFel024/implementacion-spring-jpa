package org.eafit.reto.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// POJO -> Hibernate (ORM) -> SQL

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Persona {
    //@Id
    //private UUID id;
    private String nombre;
    @Id
    @Column(nullable = false)
    private Long cedula;
}
