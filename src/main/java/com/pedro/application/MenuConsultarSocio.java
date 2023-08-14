package com.pedro.application;

import com.google.gson.JsonObject;
import com.pedro.domain.SocioService;

import java.util.Scanner;

public class MenuConsultarSocio {
    public void menuConsulta(){
        String doc;
        SocioService socioSc = new SocioService();

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o documento: ");
        doc = sc.next();

        JsonObject socio = socioSc.consultar(doc);

        if(socio != null) {
            System.out.println("Carteirinha do associado: " + socio.get("carteirinha"));
            System.out.println("Nome do associado: " + socio.get("nome"));
            System.out.println("Data de associacao: " + socio.get("dataAssociacao"));
            System.out.println("Documento do associado: " + socio.get("documento"));
        } else{
            System.out.println("Socio nao encontrado.");
        }

    }
}
