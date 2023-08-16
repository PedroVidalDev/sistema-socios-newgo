package com.pedro.infrastructure.daos;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AgendaDAO {
    // atualizando o arquivo json dos agendamento
    public void create(JsonArray listaSocios) throws IOException {
        FileWriter writer = new FileWriter("src\\main\\java\\com\\pedro\\db\\agendas.json");
        BufferedWriter wr = new BufferedWriter(writer);

        wr.write(listaSocios.toString());
        wr.close();
        writer.close();
    }

    // lendo o arquivo inteiro
    public JsonArray read() throws IOException{
        String filePath = "src\\main\\java\\com\\pedro\\db\\agendas.json";
        Path path = Paths.get(filePath);

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            JsonParser parser = new JsonParser();
            JsonElement tree = parser.parse(reader);
            JsonArray array = tree.getAsJsonArray();
            JsonArray arrayNovo = new JsonArray();

            for (JsonElement element : array) {
                if (element.isJsonObject()) {
                    JsonObject local = element.getAsJsonObject();
                    arrayNovo.add(local);
                }
            }
            return arrayNovo;
        }
    }
}
