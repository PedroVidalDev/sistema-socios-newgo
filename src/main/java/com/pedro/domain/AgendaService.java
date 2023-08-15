package com.pedro.domain;

import com.google.gson.JsonArray;
import com.pedro.infrastructure.daos.LocalDAO;

import java.io.IOException;

public class AgendaService {
    public JsonArray listaLocais() throws IOException {
        LocalDAO localCRUD = new LocalDAO();
        return localCRUD.read();
    }
}
