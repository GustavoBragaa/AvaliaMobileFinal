package com.example.guga.avaliamobile.Activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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

    AvaliacoesDAO AvaliacoesDAO = new AvaliacoesDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionaaparelho);
        //Chamadno Metodo para popular Spinner
        CarregaSpinner();


    }

    private void CarregaSpinner() {
        // Base de dados handler
        AvaliacoesDAO db = new AvaliacoesDAO(getApplicationContext());

        //Pegando valor da Spinner
        Spinner spModelo = (Spinner) findViewById(R.id.spModelo);

        //colocando os valores pegos pelo meto e colocando na lista
        List<String> valores = db.ObterTodosOsValores();

        // Criando Adapter para spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, valores);

        // Layout padrão para spinner
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Acrescentando valores na adapter
        spModelo.setAdapter(dataAdapter);
        // metodo para selecionar item da spinner
        spModelo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Item da spinner selecionado
                String itemSelecionado = (String) parent.getItemAtPosition(position);

                //Se a posição for aior que zero
                if (position > 0) {

                    String retorna = AvaliacoesDAO.BuscasValor(itemSelecionado);

                    // Chamando a mensagem
                    mensagem(parent, itemSelecionado);
                    // Criando nova intent
                    Intent atualizarIntent = new Intent(SelecionarAparelhoActivity.this, AvaliarActivity.class);
                    // Passando valor para a intent
                    atualizarIntent.putExtra("valor", retorna);
                    // Startando Intent
                    startActivity(atualizarIntent);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    // Mensagem
    public void mensagem(AdapterView<?> parent, String itemSelecionado) {
        Toast.makeText(parent.getContext(), "Você selecionou:  " + itemSelecionado,
                Toast.LENGTH_LONG).show();
    }


}










