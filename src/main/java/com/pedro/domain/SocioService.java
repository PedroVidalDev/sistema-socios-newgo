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

    // organizado as infos o socio e dps indo para o metodo de criar
    public void criar(String nome, String doc) throws IOException {

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

    // acao que chama o metodo para ler o arquivo json
    public JsonObject consultar(String doc){
        JsonObject socio = socioCRUD.consultar(doc);
        return socio;
    }

    // mesma coisa q o consultar, porem com numero de carteirinha
    public JsonObject consultarCarteirinha(int carteirinha){
        JsonObject socio = socioCRUD.consultarPorCarteirinha(carteirinha);
        return socio;
    }

    // acao que chama o delete no DAO
    public void delete(int carteirinha){
        socioCRUD.delete(carteirinha);
    }

    // salvando o socio com informacoes alteradas
    public void salvarSocioEditado(int carteirinha, String nome, String doc, String dataAssociacao) throws IOException{
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        //novo socio
        JsonObject novoSocio = new JsonObject();

        //lendo arquivo
        JsonArray arrayNovo = socioCRUD.read();

        //adicionando as informacoes
        novoSocio.addProperty("carteirinha", (Integer) carteirinha);
        novoSocio.addProperty("nome", (String) nome);
        novoSocio.addProperty("documento", (String) doc);
        novoSocio.addProperty("dataAssociacao", (String) dataAssociacao);

        arrayNovo.add(novoSocio);

        socioCRUD.create(arrayNovo);
    }

    public boolean validarCPF(String cpf){
        if(cpf.length() != 11){
            return false;
        }
        return true;
    }

    public boolean validarRG(String rg){
        if(rg.length() != 9){
            return false;
        }
        return true;
    }
}
