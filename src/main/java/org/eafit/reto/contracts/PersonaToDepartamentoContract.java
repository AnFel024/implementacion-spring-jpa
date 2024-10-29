package org.eafit.reto.contracts;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonaToDepartamentoContract {
    Long personaCedula;
    Integer departamentoId;
}
