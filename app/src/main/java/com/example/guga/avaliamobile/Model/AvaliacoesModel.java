package com.example.guga.avaliamobile.Model;

/**
 * Created by Guga on 26/10/2017.
 */

public class AvaliacoesModel {

    private int id;
    private String modelo;
    private int valor;

    public AvaliacoesModel(int id, String modelo, int valor) {
        this.id = id;
        this.modelo = modelo;
        this.valor = valor;
    }




    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return modelo;
    }

    public int getValor() {
        return valor;
    }
}

