package com.example.guga.avaliamobile.Model;

import java.io.Serializable;

/**
 * Created by Guga on 09/10/2017.
 */
//Declarando Atributos que utilizaremos
public class UsuarioModel implements Serializable {
    private Long id;
    private String usuario;
    private String email;
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
