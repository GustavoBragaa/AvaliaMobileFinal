package com.example.guga.avaliamobile.Activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.guga.avaliamobile.DAO.Avaliacoes;
import com.example.guga.avaliamobile.R;

public class AvaliarActivity extends AppCompatActivity {
    String retorna;
    Switch switch1;
    Switch switch2;
    int x1;
    int x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliar);

        // recebendo valores da Activity anterior
        Intent intent = getIntent();
        retorna = intent.getStringExtra("valor");

        final int numero = Integer.parseInt(retorna);
        // pegando valor do Switch
        switch1 = (Switch) findViewById(R.id.switch1);
        // Verificando se o Switch esta true ou falso
        final Boolean switchState = switch1.isChecked();

        switch2 = (Switch) findViewById(R.id.switch1);


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (compoundButton.isChecked()) {
                    x1 = numero;


                }
            }
        });

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()

        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton2, boolean b) {
                if (compoundButton2.isChecked()) {

                    x1 = numero / 100 * 1;

                }
            }
        });


        Button btFinalizaavaliacao = (Button) findViewById(R.id.btFinalizaAvaliacao);
        btFinalizaavaliacao.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                //Mensagem com o valor dado ao aparelho
                final AlertDialog.Builder builder = new AlertDialog.Builder(AvaliarActivity.this);
                builder.setTitle("Avaliação Finalizada");
                builder.setMessage("O Valor de seu aparelho é:  " + x1);
                builder.setPositiveButton("Aceitar", new DialogInterface.OnClickListener() {

                    // Se Aceitar Chama Activity Filiais
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                        Intent ChamaFiliais = new Intent(AvaliarActivity.this, FiliaisActivity.class);
                        startActivity(ChamaFiliais);


                    }
                });

                builder.setNegativeButton("Recusar", new DialogInterface.OnClickListener() {
                    // Se recusar Chama Activity Motivo
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent ChamaTelaMotivo = new Intent(AvaliarActivity.this, FiliaisActivity.class);
                        startActivity(ChamaTelaMotivo);


                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }


        });
    }
}