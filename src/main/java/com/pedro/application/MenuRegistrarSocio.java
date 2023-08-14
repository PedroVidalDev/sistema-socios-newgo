package com.pedro.application;

import com.pedro.domain.SocioService;

import java.io.IOException;
import java.util.Scanner;
public class MenuRegistrarSocio {

    String nome, doc;

    Scanner sc = new Scanner(System.in);
    SocioService socioSc = new SocioService();
    public void menuRegistro() throws IOException {
        System.out.print("Apos a mensagem digite o seu nome: ");
        nome = sc.next();

        System.out.print("Gostaria de cadastrar CPF (1) ou RG (2)? ");

        if(sc.nextInt() == 1){
            System.out.print("Ok, digite seu CPF: ");
            doc = sc.next();
        }

        else if(sc.nextInt() == 2){
            System.out.print("Ok, digite seu RG: ");
            doc = sc.next();
        }

        else{
            System.out.println("Opcao invalida");
        }

        socioSc.validar(nome, doc);

        System.out.println("Cadastro realizado.");
    }
}
