package org.eafit.reto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

// POJO -> Hibernate (ORM) -> SQL

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PersonaPostgres {
    // @Id
    // private UUID id;
    private String nombre;
    @Id
    @Column(nullable = false)
    private Long cedula;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
