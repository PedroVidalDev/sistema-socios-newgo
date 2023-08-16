package com.pedro.application;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pedro.domain.LocalService;

import java.io.IOException;

public class MenuRelatorioLocais {

    public void menuRelatorio() throws IOException {
        LocalService localSc = new LocalService();

        JsonArray listaLocais = localSc.listaLocais();

        for(JsonElement element : listaLocais){
            if (element.isJsonObject()) {
                JsonObject local = element.getAsJsonObject();

                String nome = local.get("nome").getAsString();
                int tempo = local.get("qntHoras").getAsInt();
                String categoria = local.get("categoria").getAsString();

                System.out.println(nome + " (" + categoria + "): " + tempo + " hora(s).");
            }
        }
    }
}
