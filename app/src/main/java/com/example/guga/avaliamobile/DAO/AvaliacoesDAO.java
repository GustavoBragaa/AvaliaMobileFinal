package com.example.guga.avaliamobile.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.guga.avaliamobile.Factory.AvaliacoesFactory;
import com.example.guga.avaliamobile.Util.BancoAvaliacoes;
import com.example.guga.avaliamobile.Util.BancoUsuarios;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guga on 31/10/2017.
 */

public class AvaliacoesDAO {
    AvaliacoesFactory banco;
    SQLiteDatabase db;

    public AvaliacoesDAO(Context context) {
        banco = new AvaliacoesFactory(context);
    }


    public List<String> ObterTodosOsValores() {
        List<String> valores = new ArrayList<String>();

        // query seleciona tudo
        String selectQuery = "SELECT  * FROM " + BancoAvaliacoes.TABELA_NOME;

        db = banco.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                valores.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // Fechando conexão
        cursor.close();
        db.close();


        return valores;
    }


    public String BuscasValor(String itemSelecionado) {

        String selectQuery =
                "SELECT * FROM " + BancoAvaliacoes.TABELA_NOME + " WHERE modelo = '" + itemSelecionado + "'";

        db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        cursor.moveToFirst();


        return String.valueOf(cursor.getInt(2));
    }

}





