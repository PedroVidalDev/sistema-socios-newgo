package com.pedro.application;

import com.pedro.domain.LocalService;
import com.pedro.domain.SocioService;

import java.io.IOException;
import java.util.Scanner;

public class MenuCriarLocal {
    Scanner sc = new Scanner(System.in);

    LocalService localSc = new LocalService();
    public void menuCria() throws IOException {
        String nomeLocal, categoriaLocal;
        int qntPessoas;

        try {
            System.out.print("Digite o nome do novo espaco: ");
            nomeLocal = sc.nextLine();

            System.out.print("Escreva a categoria do espaco (esporte, recreacao ou relaxamento): ");
            categoriaLocal = sc.nextLine();

            System.out.print("Qual a quantidade maxima de pessoas no local: ");
            qntPessoas = sc.nextInt();

            localSc.criar(nomeLocal, qntPessoas, categoriaLocal);

            System.out.println("Local cadastrado com sucesso!");
        } catch(Error e){
            System.out.println("Valor inserido esta invalido..");
        }
    }}
