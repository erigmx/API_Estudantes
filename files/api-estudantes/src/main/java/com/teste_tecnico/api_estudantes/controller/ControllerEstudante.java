package com.teste_tecnico.api_estudantes.controller;

import com.teste_tecnico.api_estudantes.dto.RequestEstudante;
import com.teste_tecnico.api_estudantes.dto.ResponseEstudante;
import com.teste_tecnico.api_estudantes.service.ServiceEstudante;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/estudantes")
public class ControllerEstudante {
    private final ServiceEstudante serviceEstudante;

    public ControllerEstudante(ServiceEstudante serviceEstudante){
        this.serviceEstudante = serviceEstudante;
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody RequestEstudante request) {
        try {
            ResponseEstudante response = serviceEstudante.createStudent(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("erro", e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<ResponseEstudante>> getAllStudents() {
        return ResponseEntity.ok(serviceEstudante.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        try {
            ResponseEstudante response = serviceEstudante.getStudentById(id);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("erro", e.getMessage()));
        }
    }

    private static class Map {
        public static java.util.Map<String, String> of(String key, String value) {
            java.util.Map<String, String> map = new java.util.HashMap<>();
            map.put(key, value);
            return map;
        }
    }
    
}
