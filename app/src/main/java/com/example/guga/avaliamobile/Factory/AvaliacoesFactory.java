package com.example.guga.avaliamobile.Factory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.guga.avaliamobile.Util.BancoAvaliacoes;

/**
 * Created by Guga on 26/10/2017.
 */

public class AvaliacoesFactory extends SQLiteOpenHelper {
    SQLiteDatabase db;

    public AvaliacoesFactory(Context context) {
        super(context, BancoAvaliacoes.DATABASE_NAME, null, BancoAvaliacoes.DATABASE_VERSION);
    }

    //Metodo que ira criar o banco, executar e acrescentar valores
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String cria_sql_modelo = " CREATE TABLE " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                BancoAvaliacoes.COLUNA_MODELO + "  TEXT NOT NULL, " +
                BancoAvaliacoes.COLUNA_VALOR + " INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(cria_sql_modelo);

        String Insere_Selecione_Aqui = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('Selecione Aqui!', 0 ) ";
        String Insere_Note8 = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('Samsung Galaxy Note 8', 4500 ) ";
        String Insere_S8_ = " insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('Samsung Galaxy S8', 3500 )";
        String Insere_S7 = " insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('Samsung Galaxy S7', 2000 )";
        String Insere_S7Edge = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('Samsung Galaxy S7 Edge', 2500 )";
        String Insere_A7_2017 = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('Samsung Galaxy A7 2017', 1400 )";
        String Insere_A5_2017 = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('Samsung Galaxy A5 2017', 1100 )";
        String Insere_J5_Prime = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('Samsung Galaxy J5 Prime', 1100 )";
        String Insere_J5_Pro = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('Samsung Galaxy J5 Pro', 1200 )";
        String Insere_Moto_Z2_Play = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('Moto Z2 Play ', 1500 )";
        String Insere_Moto_Z2_Projector = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('Moto Z2 Projector Edition ', 2000 )";
        String Insere_Moto_Z2_Sound = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('Moto Z2 Sound Edition', 1800 )";
        String Insere_Moto_G5 = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('Moto G5  ', 600 )";
        String Insere_Moto_G5_Plus = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('Moto G5 Plus ', 680 )";
        String Insere_Moto_G5S = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('Moto G5S  ', 700 )";
        String Insere_Moto_G5S_Plus = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('Moto G5S Plus ', 750 )";
        String Insere_G6 = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('LG G6  ', 2000 )";
        String Insere_Q6 = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('LG Q6  ', 900 )";
        String Insere_K10_2017 = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('LG K10 2017 ', 500 )";
        String Insere_K4_2017 = "insert into " + BancoAvaliacoes.TABELA_NOME + " ( " + BancoAvaliacoes.COLUNA_MODELO + "," + BancoAvaliacoes.COLUNA_VALOR + " ) values ('LG K4 2017 ', 350 )";

        sqLiteDatabase.execSQL(Insere_Selecione_Aqui);
        sqLiteDatabase.execSQL(Insere_Note8);
        sqLiteDatabase.execSQL(Insere_S8_);
        sqLiteDatabase.execSQL(Insere_S7);
        sqLiteDatabase.execSQL(Insere_S7Edge);
        sqLiteDatabase.execSQL(Insere_A7_2017);
        sqLiteDatabase.execSQL(Insere_A5_2017);
        sqLiteDatabase.execSQL(Insere_J5_Prime);
        sqLiteDatabase.execSQL(Insere_J5_Pro);
        sqLiteDatabase.execSQL(Insere_Moto_Z2_Play);
        sqLiteDatabase.execSQL(Insere_Moto_Z2_Projector);
        sqLiteDatabase.execSQL(Insere_Moto_Z2_Sound);
        sqLiteDatabase.execSQL(Insere_Moto_G5);
        sqLiteDatabase.execSQL(Insere_Moto_G5_Plus);
        sqLiteDatabase.execSQL(Insere_Moto_G5S);
        sqLiteDatabase.execSQL(Insere_Moto_G5S_Plus);
        sqLiteDatabase.execSQL(Insere_G6);
        sqLiteDatabase.execSQL(Insere_Q6);
        sqLiteDatabase.execSQL(Insere_K10_2017);
        sqLiteDatabase.execSQL(Insere_K4_2017);

    }


    //Verificadno se existe uma nova versão, se houver exclui e cria o banco de dados novamente
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BancoAvaliacoes.TABELA_NOME);
        onCreate(sqLiteDatabase);

    }
}


