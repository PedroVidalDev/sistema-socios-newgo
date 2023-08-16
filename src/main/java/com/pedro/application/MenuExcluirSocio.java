package com.pedro.application;

import com.pedro.domain.SocioService;

import java.util.Scanner;

public class MenuExcluirSocio {

    Scanner sc = new Scanner(System.in);
    SocioService socioSc = new SocioService();
    public void menuExclui(){
        int carteirinha;

        try {
            System.out.print("Digite o numero da carteirinha do socio: ");
            carteirinha = sc.nextInt();

            socioSc.delete(carteirinha);

            System.out.println("Socio excluido com sucesso!");
        } catch(Error e){
            System.out.println("Algum valor inserido esta errado ou socio nao existe");
        }
    }
}
