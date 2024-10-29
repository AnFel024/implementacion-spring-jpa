package org.eafit.reto.models.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "entidad")
public class Entidad {
    @Id
    private String entity_id;
    private String identificador;

    // Getters y setters
}