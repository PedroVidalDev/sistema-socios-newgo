package com.pedro.infrastructure.entidades;

public class Local {
    private int id;
    private String nome;
    private Float qntHoras;
    private int qntPessoas;
    private String categoria;
    private String[] datas;

    public Local(int id, String nome, Float qntHoras, String[] datas, int qntPessoas, String categoria){
        this.id = id;
        this.nome = nome;
        this.qntHoras = qntHoras;
        this.datas = datas;
        this.qntPessoas = qntPessoas;
        this.categoria = categoria;
    }
}
