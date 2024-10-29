package org.eafit.reto.controller;

import org.eafit.reto.models.JavaPojo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

import static ch.qos.logback.core.util.StringUtil.isNullOrEmpty;


@RestController
@RequestMapping("/demo")
public class DemoController {

    @PostMapping("/json_types")
    public ResponseEntity<Object> ping(@RequestBody JavaPojo pojo) {
        try {
            if (isNullOrEmpty(pojo.getClave_string())) {
                System.out.println("clave_string is required");
                return ResponseEntity.badRequest().body(Map.of("error", "clave_string is required"));
            }
            return ResponseEntity.ok(pojo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", e.getMessage()));
        }

    }
}
