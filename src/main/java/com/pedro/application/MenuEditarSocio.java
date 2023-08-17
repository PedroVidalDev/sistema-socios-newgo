package com.pedro.application;

import com.google.gson.JsonObject;
import com.pedro.domain.SocioService;

import java.io.IOException;
import java.util.Scanner;

public class MenuEditarSocio {
    Scanner sc = new Scanner(System.in);
    SocioService socioSc = new SocioService();
    public void menuEdita() throws IOException {
        int carteirinha;
        String nome, doc;

        try {
            System.out.print("Digite o numero da carteirinha do socio: ");
            carteirinha = sc.nextInt();

            JsonObject socio = socioSc.consultarCarteirinha(carteirinha);

            if(socio != null) {
                System.out.print("Digite o novo nome do socio (antes " + socio.get("nome") + "): ");
                nome = sc.next();

                System.out.print("Digite o novo documento do socio (antes " + socio.get("documento") + "): ");
                doc = sc.next();

                socioSc.delete(carteirinha);

                socioSc.salvarSocioEditado(carteirinha, nome, doc, socio.get("dataAssociacao").getAsString());

                System.out.println("Socio editado com sucesso!");

            } else{
                System.out.println("Socio nao encontrado");
            }

        } catch(Error e){
            System.out.println("Algum valor inserido esta invalido");
        }
    }
}
