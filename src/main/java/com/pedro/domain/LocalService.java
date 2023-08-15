package com.pedro.domain;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pedro.infrastructure.daos.LocalDAO;
import com.pedro.infrastructure.daos.SocioDAO;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalService {
    LocalDAO localCRUD = new LocalDAO();

    public void validar(String nome, int qntPessoas, String categoria) throws IOException {

        //novo socio
        JsonObject novoSocio = new JsonObject();

        //lendo arquivo
        JsonArray arrayNovo = localCRUD.read();

        //adicionando as informacoes
        novoSocio.addProperty("id", (Integer) arrayNovo.size());
        novoSocio.addProperty("nome", (String) nome);
        novoSocio.addProperty("qntHoras", 0);
        novoSocio.add("datas", new JsonArray());
        novoSocio.addProperty("qntPessoas", (Integer) qntPessoas);
        novoSocio.addProperty("categoria", (String) categoria);

        arrayNovo.add(novoSocio);

        localCRUD.create(arrayNovo);
    }
}
