package com.teste_tecnico.api_estudantes.service;

import com.teste_tecnico.api_estudantes.dto.RequestEstudante;
import com.teste_tecnico.api_estudantes.dto.ResponseEstudante;
import com.teste_tecnico.api_estudantes.model.Estudante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class ServiceEstudante {
    private final List<Estudante> estudantes = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(1);
    
    public ResponseEstudante createStudent(RequestEstudante request) {
        if (request.getNota() == null || request.getNota() < 0 || request.getNota() > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10");
        }
        
        if (request.getNome() == null || request.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome é obrigatório");
        }
        
        Estudante estudante = new Estudante(
        contadorId.getAndIncrement(),
        request.getNome(),
        request.getNota());
        
        estudantes.add(estudante);
    
        return toResponse(estudante);
    }

    public List<ResponseEstudante> getAllStudents() {
        return estudantes.stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }


    public ResponseEstudante getStudentById(Long id) {
        Estudante estudante = estudantes.stream()
            .filter(s -> s.getId() == id)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Estudante não encontrado"));
        
        return toResponse(estudante);
    }


    private ResponseEstudante toResponse(Estudante estudante) {
        Character primeiraLetraNaoRepetida = primeiraLetraNaoRepetida(estudante.getNome());
        return new ResponseEstudante(
            estudante.getId(),
            estudante.getNome(),
            estudante.getNota(),
            primeiraLetraNaoRepetida
        );
    }

    private Character primeiraLetraNaoRepetida(String nome) {
        String nomeLower = nome.toLowerCase();
        Map<Character, Integer> contadorChar = new HashMap<>();
        
        for (char c : nomeLower.toCharArray()) {
            contadorChar.put(c, contadorChar.getOrDefault(c, 0) + 1);
        }
        
        // Encontra o primeiro caractere que aparece apenas uma vez
        for (char c : nomeLower.toCharArray()) {
            if (contadorChar.get(c) == 1) {
                return c;
            }
        }
        
        // Se todas as letras se repetem, retorna '_'
        return '_';
    }

}
