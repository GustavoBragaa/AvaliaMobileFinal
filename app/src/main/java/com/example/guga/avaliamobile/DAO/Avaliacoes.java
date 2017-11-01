package com.example.guga.avaliamobile.DAO;

/**
 * Created by Guga on 26/10/2017.
 */

public class Avaliacoes {

    private int id;
    private String modelo;
    private int valor;


    public Avaliacoes(int id, String modelo, int valor) {
        this.id = id;
        this.modelo = modelo;
        this.valor = valor;

    }

    public Avaliacoes() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


}

