package org.eafit.reto.contracts.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonaToDepartamentoRequest {
    Long personaCedula;
    Integer departamentoId;
}
