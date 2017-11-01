package com.example.guga.avaliamobile.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.guga.avaliamobile.Util.BancoUsuarios;

/**
 * Created by Guga on 30/10/2017.
 */

public class UsuarioDAO {
    public static final int LIVROS_TOTAL = 1;
    private SQLiteDatabase db;
    private BancoUsuarios bancoUsuarios;
    SQLiteOpenHelper   dbHelper;

    public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {BancoUsuarios.COLUNA_ID, BancoUsuarios.COLUNA_NOME, BancoUsuarios.COLUNA_EMAIL, BancoUsuarios.COLUNA_SENHA, };
      //  dbHelper = new UsuarioFactory(this);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        cursor = db.query(BancoUsuarios.TABELA_NOME, campos, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


}
