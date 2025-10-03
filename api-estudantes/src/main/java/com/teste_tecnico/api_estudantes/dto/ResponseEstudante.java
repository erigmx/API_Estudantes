package com.teste_tecnico.api_estudantes.dto;

public class ResponseEstudante {
    private long id;
    private String nome;
    private Double nota;
    private char primeiraLetraNaoRepetida;



    public ResponseEstudante(long id, String nome, Double nota, char primeiraLetraNaoRepetida){
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.primeiraLetraNaoRepetida = primeiraLetraNaoRepetida;
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
    public char getPrimeiraLetraNaoRepetida() {
        return primeiraLetraNaoRepetida;
    }
    public void setPrimeiraLetraNaoRepetida(char primeiraLetraNaoRepetida) {
        this.primeiraLetraNaoRepetida = primeiraLetraNaoRepetida;
    }

    
}
