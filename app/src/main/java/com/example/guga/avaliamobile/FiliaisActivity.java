package com.example.guga.avaliamobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class FiliaisActivity extends AppCompatActivity {
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filiais);

        final Spinner spCidade = (Spinner) findViewById(R.id.spCidade);
        final Spinner spEstado = (Spinner) findViewById(R.id.spEstado);
        final TextView txEndereco = (TextView) findViewById(R.id.txEndereco);


        //Criando um Array - pegando valores do arquivo xml de estados  e passando um layout padrão de spinner
        ArrayAdapter<CharSequence> estadoAdapter = ArrayAdapter.createFromResource(FiliaisActivity.this, R.array.estados_array, android.R.layout.simple_spinner_item);
        // Especificando o layout a ser usado quando a lista de opções aparecer
        estadoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setando adapter no spinner
        spEstado.setAdapter(estadoAdapter);
        //Mandando valor escolhida para o metodo
        spEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                //Transformando posição selecionada em String
                string = parent.getItemAtPosition(position).toString();


                if (string.equals("Selecione um Estado")) {

                    ArrayAdapter<CharSequence> cidadeAdapter = ArrayAdapter.createFromResource(FiliaisActivity.this, R.array.selecione_array, android.R.layout.simple_spinner_item);
                    cidadeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spCidade.setAdapter(cidadeAdapter);
                }


                if (string.equals("Paraná")) {
                    ArrayAdapter<CharSequence> cidadeAdapter = ArrayAdapter.createFromResource(FiliaisActivity.this, R.array.cidades_Pr_array, android.R.layout.simple_spinner_item);
                    cidadeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spCidade.setAdapter(cidadeAdapter);
                }
                if (string.equals("São Paulo")) {
                    ArrayAdapter<CharSequence> cidadeAdapter = ArrayAdapter.createFromResource(FiliaisActivity.this, R.array.cidades_Sp_array, android.R.layout.simple_spinner_item);
                    cidadeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spCidade.setAdapter(cidadeAdapter);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });


        spCidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                string = parent.getItemAtPosition(position).toString();

                if (string.equals("Primeiro Selecione um Estado") || string.equals("Selecione Uma Cidade")) {
                    txEndereco.setText("");
                }


                if (string.equals("Curitiba")) {
                    txEndereco.setText("Nosso  Endereço Nesta Cidade Fica Em: " +
                            "   " +
                            "Rua Getulio Vargas, Nº 902, Bairro: Centro, CEP: 80.230-030 ");
                }
                if (string.equals("Pinhais")) {
                    txEndereco.setText("Nosso  Endereço Nesta Cidade Fica Em: " +
                            "Rua Jatobá, Nº 232, Bairro: Jardim Karla, CEP: 83.328-160");
                }
                if (string.equals("São Jose dos Pinhais")) {
                    txEndereco.setText("Nosso  Endereço Nesta Cidade Fica Em: " +
                            "Rua XV de Novembro, Nº 1699, Bairro: Centro, CEP: 83.005-000 ");
                }
                if (string.equals("São Paulo")) {
                    txEndereco.setText("Nosso  Endereço Nesta Cidade Fica Em: " +
                            "Rua Amintas de Barros, Nº 528, Bairro: Joaquina, Cep: 87.198-054 ");
                }
                if (string.equals("Guarulhos")) {
                    txEndereco.setText("Nosso  Endereço Nesta Cidade Fica Em: " +
                            "Av. Vitor Ferreira, Nº 2561, Bairro: Cerro Azul, Cep: 82.469-043 ");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}



