package com.example.guga.avaliamobile.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.guga.avaliamobile.Factory.UsuarioFactory;
import com.example.guga.avaliamobile.Util.BancoUsuarios;

/**
 * Created by Guga on 30/10/2017.
 */

public class UsuarioDAO {
    SQLiteDatabase db;
    UsuarioFactory banco;
    SQLiteOpenHelper dbHelper;


    public UsuarioDAO(Context context) {
        banco = new UsuarioFactory(context);
    }


    // Metodo que ira pegar os dados inseridos e mandar para o banco e retornar
    public long insereUsuario(String nome, String email, String senha) {
        db = banco.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(BancoUsuarios.COLUNA_NOME, nome);
        values.put(BancoUsuarios.COLUNA_EMAIL, email);
        values.put(BancoUsuarios.COLUNA_SENHA, senha);
        long resultado = db.insert(BancoUsuarios.TABELA_NOME, null, values);

        return resultado;

    }




}
