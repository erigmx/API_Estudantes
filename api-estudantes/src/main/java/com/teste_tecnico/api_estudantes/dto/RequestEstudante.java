package com.teste_tecnico.api_estudantes.dto;

public class RequestEstudante {
    private String nome;
    private Double nota;

    public RequestEstudante() {
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getNota() {
        return nota;
    }
    public void setNota(Double nota) {
        this.nota = nota;
    }
    
   

}
