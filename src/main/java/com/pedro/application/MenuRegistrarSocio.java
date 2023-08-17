package com.pedro.application;

import com.pedro.domain.SocioService;

import java.io.IOException;
import java.util.Scanner;
public class MenuRegistrarSocio {

    String nome, doc;
    int escDoc;
    boolean validaDoc;

    Scanner sc = new Scanner(System.in);
    SocioService socioSc = new SocioService();
    public void menuRegistro() throws IOException {
        try {
            System.out.print("Apos a mensagem digite o seu nome: ");
            nome = sc.next();

            System.out.print("Gostaria de cadastrar CPF (1) ou RG (2)? ");
            escDoc = sc.nextInt();

            if (escDoc == 1) {
                System.out.print("Ok, digite seu CPF: ");
                doc = sc.next();
                validaDoc = socioSc.validarCPF(doc);
            } else if (escDoc == 2) {
                System.out.print("Ok, digite seu RG: ");
                doc = sc.next();
                validaDoc = socioSc.validarRG(doc);
            } else {
                System.out.println("Opcao invalida");
            }

            if(validaDoc == true) {
                socioSc.criar(nome, doc);

                System.out.println("Cadastro realizado.");
            } else{
                System.out.println("Documento invalido.");
            }
        } catch(Error e){
            System.out.println("Algum valor inserido esta incorreto");
        }
    }
}
