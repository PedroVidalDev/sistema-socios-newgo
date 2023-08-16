package com.pedro.application;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pedro.domain.AgendaService;
import com.pedro.domain.LocalService;
import com.pedro.infrastructure.daos.AgendaDAO;
import com.pedro.infrastructure.daos.LocalDAO;

import java.io.IOException;
import java.util.Scanner;

public class MenuCriarAgenda {

    AgendaService agendaSc = new AgendaService();
    LocalService localSc = new LocalService();

    Scanner sc = new Scanner(System.in);
    public void menuCria() throws IOException {
        int carteirinha, escolhaLocal, horaInicio, horaFim, qntPessoas;
        String data;

        System.out.print("Digite o numero de carteirinha do socio: ");
        carteirinha = sc.nextInt();

        // FAZER VALIDACAO AQ

        JsonArray listaLocais = agendaSc.listaLocais();

        for(JsonElement element : listaLocais){
            JsonObject local = element.getAsJsonObject();
            System.out.println((local.get("id")) + ") " + (local.get("nome")));
        }

        System.out.print("Selecione um local com base no seu numero: ");
        escolhaLocal = sc.nextInt();

        JsonObject local = localSc.selecionarLocal(escolhaLocal);

        System.out.print("Digite a data que ira utilizar (d/m/a): ");
        data = sc.next();

        System.out.print("Digite a qnt. de pessoas que irao utilizar: ");
        qntPessoas = sc.nextInt();

        System.out.print("Digite a hora de inicio: ");
        horaInicio = sc.nextInt();

        System.out.print("Digite a hora do fim: ");
        horaFim = sc.nextInt();

        System.out.println("Local: " + local.get("nome").getAsString());
        System.out.println("Por " + (horaFim - horaInicio));
        System.out.println("No dia: " + data);

        // adicionar a qnt de horas e a data no json dos locais
        // criar agendamento com o socio no json das agendas
    }
}
