package com.example.guga.avaliamobile.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.guga.avaliamobile.Factory.AvaliacoesFactory;
import com.example.guga.avaliamobile.Util.BancoAvaliacoes;

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


    public List<String> getAllLabels() {
        List<String> labels = new ArrayList<String>();

        // query seleciona tudo
        String selectQuery = "SELECT  * FROM " + BancoAvaliacoes.TABELA_NOME;

        db = banco.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // Fechando conexão
        cursor.close();
        db.close();


        return labels;
    }

}

