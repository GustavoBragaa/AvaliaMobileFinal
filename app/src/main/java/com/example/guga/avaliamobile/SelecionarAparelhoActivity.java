package com.example.guga.avaliamobile;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.guga.avaliamobile.DAO.AvaliacoesDAO;
import com.example.guga.avaliamobile.DAO.UsuarioDAO;
import com.example.guga.avaliamobile.Model.AvaliacoesModel;

import java.util.ArrayList;
import java.util.List;

public class SelecionarAparelhoActivity extends AppCompatActivity {
    SQLiteOpenHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionaaparelho);


        Button btComecar = (Button) findViewById(R.id.btComecar);
        btComecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ChamaAvaliar = new Intent(SelecionarAparelhoActivity.this, AvaliarActivity.class);
                startActivity(ChamaAvaliar);
            }
        });
    }


    public List<AvaliacoesModel> getAllLabels() {
        List<AvaliacoesModel> labels = new ArrayList<AvaliacoesModel>();
        // Seleciona todas as consultas
        String selectQuery = "SELECT  * FROM Tbl_Modelo";

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        // Loop através de todas as linhas e adicionando à lista
        if (cursor.moveToFirst()) {
            do {
                labels.add(new AvaliacoesModel(cursor.getInt(0), cursor.getString(1), cursor.getInt(2)));
            } while (cursor.moveToNext());
        }

        // Fecha conexão
        cursor.close();
        db.close();

        return labels;
    }

    private void CarregaSpinner() {


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // database handler
   //     DatabaseSpinner db = new DatabaseSpinner(getApplicationContext());
    //    List<AvaliacoesModel> lables = db.getAllLabels();
        // Criando adaptador para o spinner
   //     ArrayAdapter<AvaliacoesModel> dataAdapter = new ArrayAdapter<AvaliacoesModel>(this,
   //             android.R.layout.simple_spinner_item, lables);
     //   dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Anexando adaptador de dados para o spinner
     //   spinner.setAdapter(dataAdapter);
    }

}


