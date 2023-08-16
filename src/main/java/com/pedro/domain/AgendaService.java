package com.pedro.domain;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pedro.infrastructure.daos.AgendaDAO;
import com.pedro.infrastructure.daos.LocalDAO;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AgendaService {

    AgendaDAO agendaCRUD = new AgendaDAO();

    public void criar(int id, int carteirinha, int horaInicio, int horaFim, String data) throws IOException{

        //novo socio
        JsonObject novaAgenda = new JsonObject();

        //lendo arquivo
        JsonArray arrayNovo = agendaCRUD.read();

        //adicionando as informacoes
        novaAgenda.addProperty("localID", (Integer) id);
        novaAgenda.addProperty("SocioID", (Integer) carteirinha);
        novaAgenda.addProperty("data", (String) data);
        novaAgenda.addProperty("tempo", (String) (horaInicio + "h ate as " + horaFim + "h"));

        arrayNovo.add(novaAgenda);

        agendaCRUD.create(arrayNovo);
    }
}
