package com.pedro.domain;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import com.google.gson.*;
import com.pedro.infrastructure.daos.SocioDAO;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SocioService {

    SocioDAO socioCRUD = new SocioDAO();

    public void validar(String nome, String doc) throws IOException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        //novo socio
        JsonObject novoSocio = new JsonObject();

        //lendo arquivo
        JsonArray arrayNovo = socioCRUD.read();

        //adicionando as informacoes
        novoSocio.addProperty("carteirinha", (Integer) arrayNovo.size());
        novoSocio.addProperty("nome", (String) nome);
        novoSocio.addProperty("documento", (String) doc);
        novoSocio.addProperty("dataAssociacao", (String) dtf.format(now));

        arrayNovo.add(novoSocio);

        socioCRUD.create(arrayNovo);
    }
    public JsonObject consultar(String doc){
        JsonObject socio = socioCRUD.consultar(doc);
        return socio;
    }

    public void delete(int carteirinha){
        socioCRUD.delete(carteirinha);
    }
}
