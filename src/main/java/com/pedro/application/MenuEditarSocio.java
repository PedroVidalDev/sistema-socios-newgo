package com.pedro.application;

import com.google.gson.JsonObject;
import com.pedro.domain.SocioService;

import java.util.Scanner;

public class MenuEditarSocio {
    Scanner sc = new Scanner(System.in);
    SocioService socioSc = new SocioService();
    public void menuExclui(){
        int carteirinha;
        String nome, doc;

        System.out.print("Digite o numero da carteirinha do socio: ");
        carteirinha = sc.nextInt();



        System.out.print("Digite o novo nome do socio: ");
        nome = sc.next();

        System.out.print("Digite o novo documento do socio: ");
        doc = sc.next();



        System.out.println("Socio editado com sucesso!");
    }
}
