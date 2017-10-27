package com.example.guga.avaliamobile.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Guga on 09/10/2017.
 */

public class UsuarioDAO extends SQLiteOpenHelper {

    //Declarando nome da Base de dados e versão
    private static final String DATABASE_NAME = "info.db";
    private static final int DATABASE_VERSION = 3;
    // Declarando nome dos campos que utilizaremos
    public static final String TABELA_NOME = "tbl_usuarios";
    public static final String COLUNA_ID = "id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_EMAIL = "email";
    public static final String COLUNA_SENHA = "senha";

    //Criando tabela com campos e tipos
    private static final String CREATE_TABLE_QUERY =
            "CREATE TABLE " + TABELA_NOME + " ( " + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    COLUNA_NOME + " TEXT NOT NULL, " +
                    COLUNA_EMAIL + " TEXT NOT NULL, " +
                    COLUNA_SENHA + " TEXT NOT NULL" + ")";


    public UsuarioDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Metodo que ira executar e criar o banco
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);

    }

    //Verificadno se existe uma nova versão, se houver exclui e cria o banco de dados novamente
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELA_NOME);
        onCreate(sqLiteDatabase);

    }
}
