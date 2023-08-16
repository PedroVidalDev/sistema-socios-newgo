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

public class LocalDAO {
    public void create(JsonArray listaSocios) throws IOException {
        FileWriter writer = new FileWriter("src\\main\\java\\com\\pedro\\db\\locais.json");
        BufferedWriter wr = new BufferedWriter(writer);

        wr.write(listaSocios.toString());
        wr.close();
        writer.close();
    }

    public JsonArray read() throws IOException{
        String filePath = "src\\main\\java\\com\\pedro\\db\\locais.json";
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

    public JsonArray delete(int id){
        String filePath = "src\\main\\java\\com\\pedro\\db\\locais.json";
        Path path = Paths.get(filePath);

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            JsonParser parser = new JsonParser();
            JsonElement tree = parser.parse(reader);
            JsonArray array = tree.getAsJsonArray();
            JsonArray arrayNovo = new JsonArray();

            for (JsonElement element : array) {
                if (element.isJsonObject()) {
                    JsonObject local = element.getAsJsonObject();
                    if(local.get("id").getAsInt() != id){
                        arrayNovo.add(local);
                    }
                }
            }
            return arrayNovo;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
