package com.pedro.infrastructure.entidades;

public class Agenda {
    private int localID;
    private int socioID;
    private String data;
    private String tempo;

    public Agenda(int localID, int socioID, String data, String tempo){
        this.localID = localID;
        this.socioID = socioID;
        this.data = data;
        this.tempo = tempo;
    }
}
