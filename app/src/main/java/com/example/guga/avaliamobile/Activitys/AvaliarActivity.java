package com.example.guga.avaliamobile.Activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.guga.avaliamobile.R;

public class AvaliarActivity extends AppCompatActivity {
    String retorna;
    int x1;
    int x2;
    int x3;
    int x4;
    RadioButton rbSim, rbNao,
            rbPer, rbRisc, rbTrinc,
            rbPerf, rbAmass, rbDesga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliar);


        //Pegando id do botão
        Button btFinalizaavaliacao = (Button) findViewById(R.id.btFinalizaAvaliacao);
        // Colocando evento no Botão
        btFinalizaavaliacao.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                // recebendo valores da Activity anterior
                Intent intent = getIntent();
                retorna = intent.getStringExtra("valor");

                //Transformando variavel em int
                int numero = Integer.parseInt(retorna);


                //pegando id's dos radio
                rbSim = (RadioButton) findViewById(R.id.rbSim);
                rbNao = (RadioButton) findViewById(R.id.rbNao);
                rbPer = (RadioButton) findViewById(R.id.rbPer);
                rbRisc = (RadioButton) findViewById(R.id.rbRisc);
                rbTrinc = (RadioButton) findViewById(R.id.rbTrinc);
                rbPerf = (RadioButton) findViewById(R.id.rbPerf);
                rbAmass = (RadioButton) findViewById(R.id.rbAmass);
                rbDesga = (RadioButton) findViewById(R.id.rbDesga);


                rbSim.setChecked(boolean checked);
                rbNao.setChecked (boolean rbNao1);
                rbPer.setChecked (boolean rbPer1);
                rbRisc.setChecked (boolean rbRisc1);
                rbTrinc.setChecked (boolean rbTrinc1);
                rbPerf.setChecked (boolean rbPerf1);
                rbAmass.setChecked (boolean rbAmass1);
                rbDesga.setChecked (boolean rbDesga1);



                //calculando a variavel
                if (rbSim.isChecked() || rbPer.isChecked() || rbPerf.isChecked()) {
                    x4 = numero;

                }


                if (rbNao.isChecked();) {
                    x1 = numero / 100 * 10;
                }


                //  if (rbSim.no) {
                //      final AlertDialog.Builder builder = new AlertDialog.Builder(AvaliarActivity.this);
                //      builder.setTitle("ERRO!");
                //      builder.setMessage("O Valor de seu aparelho é:  " + x4);

                //       AlertDialog dialog = builder.create();
                //       dialog.show();

                //    }


                if (rbPer.isChecked() || x1 != numero) {
                    x2 = numero / 100 * 70;
                }


                if (rbRisc.isChecked()) {
                    x2 = numero / 100 * 50;
                }
                if (rbTrinc.isChecked()) {
                    x2 = numero / 100 * 40;
                }
                if (rbPerf.isChecked() || x1 != numero)
                    x3 = numero / 100 * 30;

                if (rbAmass.isChecked()) {
                    x3 = numero / 100 * 20;
                }
                if (rbDesga.isChecked()) {
                    x3 = numero / 100 * 10;
                }

                //Somando valores e colocando dentro de outra variavel
                x4 = x1 + x2 + x3;

                //Mensagem com o valor dado ao aparelho

                final AlertDialog.Builder builder = new AlertDialog.Builder(AvaliarActivity.this);
                builder.setCancelable(false);
                builder.setTitle("Avaliação Finalizada");
                builder.setMessage("O Valor de seu aparelho é:  " + x4);
                builder.setPositiveButton("Aceitar", new DialogInterface.OnClickListener() {

                    // Se Aceitar Chama Activity Filiais
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

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

