package com.example.guga.avaliamobile.Factory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.guga.avaliamobile.Util.BancoUsuarios;

/**
 * Created by Guga on 09/10/2017.
 */

public class UsuarioFactory extends SQLiteOpenHelper {


    public UsuarioFactory(Context context) {
        super(context, BancoUsuarios.DATABASE_NAME, null, BancoUsuarios.DATABASE_VERSION);
    }




    //Metodo que ira executar e criar o banco
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE " + BancoUsuarios.TABELA_NOME + " ( " + BancoUsuarios.COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                BancoUsuarios.COLUNA_NOME + " TEXT NOT NULL, " +
                BancoUsuarios.COLUNA_EMAIL + " TEXT NOT NULL, " +
                BancoUsuarios.COLUNA_SENHA + " TEXT NOT NULL" + ")";
        db.execSQL(sql);

    }

    //Verificadno se existe uma nova versão, se houver exclui e cria o banco de dados novamente
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + BancoUsuarios.TABELA_NOME);
        onCreate(db);

    }
}
