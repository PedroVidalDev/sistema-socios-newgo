package com.pedro.application;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pedro.domain.AgendaService;
import com.pedro.domain.LocalService;
import com.pedro.domain.SocioService;
import com.pedro.infrastructure.entidades.Socio;

import java.io.IOException;
import java.util.Scanner;

public class MenuRelatorioLocaisPorSocio {

    Scanner sc = new Scanner(System.in);
    AgendaService agendaSc = new AgendaService();
    SocioService socioSc = new SocioService();
    LocalService localSc = new LocalService();

    public void menuRelatorioSocio() throws IOException {
        int carteirinha;

        try {
            System.out.print("Digite o numero de carteira do socio: ");
            carteirinha = sc.nextInt();
            JsonObject socio = socioSc.consultarCarteirinha(carteirinha);

            if(socio != null) {
                JsonArray reservas = agendaSc.consultar(carteirinha);

                System.out.println("O socio " + socio.get("nome").getAsString() + " possui o seguinte historico: ");

                for (JsonElement element : reservas) {
                    JsonObject reserva = element.getAsJsonObject();
                    JsonObject local = localSc.selecionarLocal(reserva.get("LocalID").getAsInt());
                    System.out.println("Local: " + local.get("nome").getAsString());
                    System.out.println("Tempo: " + reserva.get("tempo").getAsString());
                    System.out.println("Data: " + reserva.get("data").getAsString());
                }
            } else{
                System.out.println("Socio nao encontrado..");
            }
        } catch(Error e){
            System.out.println("Erro na insercao do numero de carteira..");
        }

    }
}
