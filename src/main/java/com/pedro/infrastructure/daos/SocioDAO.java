package com.pedro.infrastructure.daos;

import com.google.gson.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SocioDAO {
    public void create(JsonArray listaSocios) throws IOException {
        FileWriter writer = new FileWriter("src\\main\\java\\com\\pedro\\db\\socios.json");
        BufferedWriter wr = new BufferedWriter(writer);

        wr.write(listaSocios.toString());
        wr.close();
        writer.close();
    }

    public JsonArray read() throws IOException{
        String filePath = "src\\main\\java\\com\\pedro\\db\\socios.json";
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

    public JsonObject consultar(String doc){
        String filePath = "src\\main\\java\\com\\pedro\\db\\socios.json";
        Path path = Paths.get(filePath);

        try(Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            JsonParser parser = new JsonParser();
            JsonElement tree = parser.parse(reader);
            JsonArray array = tree.getAsJsonArray();

            for (JsonElement element : array) {

                if (element.isJsonObject()) {
                    JsonObject socio = element.getAsJsonObject();
                    if(socio.get("documento").getAsString().equals(doc)){
                        return socio;
                    }
                }

            }

        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public JsonObject consultarPorCarteirinha(int carteirinha){
        String filePath = "src\\main\\java\\com\\pedro\\db\\socios.json";
        Path path = Paths.get(filePath);

        try(Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            JsonParser parser = new JsonParser();
            JsonElement tree = parser.parse(reader);
            JsonArray array = tree.getAsJsonArray();

            for (JsonElement element : array) {

                if (element.isJsonObject()) {
                    JsonObject socio = element.getAsJsonObject();
                    if(socio.get("carteirinha").getAsInt() == carteirinha){
                        return socio;
                    }
                }

            }

        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public JsonObject delete(int carteirinha){
        String filePath = "src\\main\\java\\com\\pedro\\db\\socios.json";
        Path path = Paths.get(filePath);

        try (Reader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            JsonParser parser = new JsonParser();
            JsonElement tree = parser.parse(reader);
            JsonArray array = tree.getAsJsonArray();
            JsonArray arrayNovo = new JsonArray();
            JsonObject socioFora = new JsonObject();

            for (JsonElement element : array) {
                if (element.isJsonObject()) {
                    JsonObject socio = element.getAsJsonObject();
                    if(socio.get("carteirinha").getAsInt() != carteirinha){
                        arrayNovo.add(socio);
                    } else{
                        socioFora = socio;
                    }
                }
            }
            create(arrayNovo);
            return socioFora;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
