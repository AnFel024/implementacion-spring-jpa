package org.eafit.reto.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class JavaPojo {

    public Boolean clave_booleana;
    public Integer clave_numerica;
    public String clave_string;
    public ClaveJson clave_json;
    public ArrayList<Integer> clave_array;

    @Data
    @Builder
    public static class ClaveJson {
        public boolean clave_booleana;
        public Integer clave_numerica;
        public String clave_string;
    }
}
