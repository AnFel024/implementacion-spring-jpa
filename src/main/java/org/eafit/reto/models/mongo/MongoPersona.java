package org.eafit.reto.models.mongo;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

// POJO -> Hibernate (ORM) -> SQL

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "persona")
public class MongoPersona {
    //@Id
    //private UUID id;
    private String nombre;
    @Id
    @Column(nullable = false)
    private Long cedula;
}
