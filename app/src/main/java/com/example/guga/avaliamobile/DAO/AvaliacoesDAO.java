package com.example.guga.avaliamobile.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Guga on 26/10/2017.
 */

public class AvaliacoesDAO extends SQLiteOpenHelper {
    //Declarando nome da Base de dados e versão
    private static final String DATABASE_NAME = "info.db";
    private static final int DATABASE_VERSION = 1;


    //Criando tabela com campos e tipos
    private static final String CREATE_TABLE_QUERY =
            "CREATE TABLE Tbl_Modelo ( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    " modelo TEXT NOT NULL, " +
                    " valor INTEGER NOT NULL" + ")";


    public AvaliacoesDAO(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Metodo que ira criar o banco, executar e acrescentar valores
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('Samsung Galaxy Note 8', 5000 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('Samsung Galaxy S8', 3500 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('Samsung Galaxy S8+', 4000 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('Samsung Galaxy S7', 2000 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('Samsung Galaxy S7 Edge', 2500 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('Samsung Galaxy A7 2017', 1400 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('Samsung Galaxy A5 2017', 1100 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('Samsung Galaxy J5 Prime', 1100 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('Samsung Galaxy J5 Pro', 1200 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('Moto Z2 Play ', 1500 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('Moto Z2 Projector Edition ', 2000 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('Moto Z2 Sound Edition', 1800 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('Moto G5  ', 600 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('Moto G5 Plus ', 680 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('Moto G5S  ', 700 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('Moto G5S Plus ', 750 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('LG G6  ', 2000 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
            "(modelo, valor) values ('LG Q6  ', 900 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('LG K10 2017 ', 500 )");
        sqLiteDatabase.execSQL("insert into Tbl_Modelo" +
                "(modelo, valor) values ('LG K4 2017 ', 350 )");


    }

    //Verificadno se existe uma nova versão, se houver exclui e cria o banco de dados novamente
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Tbl_Modelo ");
        onCreate(sqLiteDatabase);

    }
}


