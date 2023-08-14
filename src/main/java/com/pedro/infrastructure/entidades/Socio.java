package com.pedro.infrastructure.entidades;

public class Socio {
    private int carteirinha;
    private String nome;
    private String dataAssociacao;
    private String documento;

    public Socio(int carteirinha, String nome, String dataAssociacao, String documento){
        this.carteirinha = carteirinha;
        this.nome = nome;
        this.dataAssociacao = dataAssociacao;
        this.documento = documento;
    }
}
