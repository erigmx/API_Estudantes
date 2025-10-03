package com.teste_tecnico.api_estudantes.model;

public class Estudante {
    private long id;
    private String nome;
    private Double nota;

    public void Estudante(){
    }

    public Estudante(long id, String nome, Double nota){
        this.id = id;
        this.nome = nome;
        this.nota = nota;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
