package com.example.guga.avaliamobile.Activitys;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.guga.avaliamobile.DAO.AvaliacoesDAO;
import com.example.guga.avaliamobile.DAO.Usuario;
import com.example.guga.avaliamobile.DAO.UsuarioDAO;
import com.example.guga.avaliamobile.Factory.AvaliacoesFactory;
import com.example.guga.avaliamobile.DAO.Avaliacoes;
import com.example.guga.avaliamobile.R;
import com.example.guga.avaliamobile.Util.BancoAvaliacoes;

import java.util.ArrayList;
import java.util.List;

public class SelecionarAparelhoActivity extends AppCompatActivity {
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionaaparelho);
        //Chamadno Metodo para popular Spinner
        loadSpinnerData();



    }

    private void loadSpinnerData() {
        // Base de dados handler
        AvaliacoesDAO db = new AvaliacoesDAO(getApplicationContext());

        //Pegando valor da Spinner
        Spinner spModelo = (Spinner) findViewById(R.id.spModelo);

        //colocando os valores pegos pelo meto e colocando na lista
        List<String> lables = db.getAllLabels();

        // Criando Adapter para spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Layout padrão para spinner
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Acrescentando valores na adapter
        spModelo.setAdapter(dataAdapter);
        spModelo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                // Item da spinner selecionado
                Avaliacoes avaliacoes = (Avaliacoes)parent.getItemAtPosition(position);
                   Intent atualizarIntent = new Intent(SelecionarAparelhoActivity.this, AvaliarActivity.class);
                    atualizarIntent.putExtra("COLUNA_VALOR", avaliacoes.getValor());
                     startActivity(atualizarIntent);



                Button btComecar = (Button) findViewById(R.id.btComecar);
                btComecar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent ChamaAvaliar = new Intent(SelecionarAparelhoActivity.this, AvaliarActivity.class);
                        startActivity(ChamaAvaliar);
                    }
                });


                    Toast.makeText(parent.getContext(), "Você selecionou:  " + string,
                          Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}













