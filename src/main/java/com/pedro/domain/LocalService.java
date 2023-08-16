package com.pedro.domain;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pedro.infrastructure.daos.LocalDAO;
import com.pedro.infrastructure.daos.SocioDAO;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalService {
    LocalDAO localCRUD = new LocalDAO();

    public void criar(String nome, int qntPessoas, String categoria) throws IOException {

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

    public JsonArray listaLocais() throws IOException {
        LocalDAO localCRUD = new LocalDAO();
        return localCRUD.read();
    }

    public JsonObject selecionarLocal(int id){
        String filePath = "src\\main\\java\\com\\pedro\\db\\locais.json";
        Path path = Paths.get(filePath);

        try(Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            JsonParser parser = new JsonParser();
            JsonElement tree = parser.parse(reader);
            JsonArray array = tree.getAsJsonArray();

            for (JsonElement element : array) {

                if (element.isJsonObject()) {
                    JsonObject local = element.getAsJsonObject();
                    if(local.get("id").getAsInt() == id){
                        return local;
                    }
                }

            }

        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void update(JsonObject local, int carteirinha, int horaInicio, int horaFim, int qntPessoas, String data) throws IOException{
        JsonObject localAtualizado = new JsonObject();
        JsonArray listaDatas = local.get("datas").getAsJsonArray();
        listaDatas.add(data);

        localAtualizado.addProperty("id", local.get("id").getAsInt());
        localAtualizado.addProperty("nome", local.get("nome").getAsString());
        localAtualizado.addProperty("qntHoras", local.get("qntHoras").getAsInt() + (horaFim - horaInicio));
        localAtualizado.add("datas", listaDatas);
        localAtualizado.addProperty("qntPessoas", local.get("qntPessoas").getAsInt());
        localAtualizado.addProperty("categoria", local.get("categoria").getAsString());

        JsonArray listaLocais = localCRUD.delete(local.get("id").getAsInt());
        listaLocais.add(localAtualizado);

        localCRUD.create(listaLocais);
    }
}
