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


                //calculando  variaveis

                if (rbSim.isChecked()) {
                    x1 = numero / 100 * 20;
                }


                if (rbPer.isChecked()) {
                    x2 = numero / 100 * 40;
                }


                if (rbRisc.isChecked()) {
                    x2 = numero / 100 * 30;
                }
                if (rbTrinc.isChecked()) {
                    x2 = numero / 100 * 20;
                }
                if (rbPerf.isChecked())
                    x3 = numero / 100 * 40;

                if (rbAmass.isChecked()) {
                    x3 = numero / 100 * 20;
                }
                if (rbDesga.isChecked()) {
                    x3 = numero / 100 * 10;
                }

                if (rbSim.isChecked() && rbPer.isChecked() && rbPerf.isChecked()) {
                    x4 = numero;

                }

                //Somando valores e colocando dentro de outra variavel
                x4 = x1 + x2 + x3;

                if (rbNao.isChecked()) {
                    x4 = 20;
                }
                if (x4 > numero) {
                    x4 = 0 + numero;
                }

                //Mensagem com o valor dado ao aparelho
                if (rbSim.isChecked() | rbNao.isChecked() && rbPer.isChecked() | rbRisc.isChecked() | rbTrinc.isChecked() && rbPerf.isChecked() | rbAmass.isChecked() | rbDesga.isChecked()) {
                    //Mensagem com o valor do aparelho
                    final AlertDialog.Builder builder = new AlertDialog.Builder(AvaliarActivity.this);
                    builder.setCancelable(false);
                    builder.setTitle("Avaliação Finalizada");
                    builder.setMessage("O Valor do aparelho " +
                            "é: R$" + x4 + ",00"


                    );
                    builder.setPositiveButton("Aceitar", new DialogInterface.OnClickListener() {

                        // Se Aceitar Chama Activity Filiais
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Intent ChamaFiliais = new Intent(AvaliarActivity.this, FiliaisActivity.class);
                            startActivity(ChamaFiliais);


                        }
                    });

                    builder.setNegativeButton("Sair", new DialogInterface.OnClickListener() {
                        // Se recusar Chama Activity Motivo
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            // Finaliza a Apllcaçao
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();

                } else {
                    if (!rbSim.isChecked() && !rbNao.isChecked()) {


                        final AlertDialog.Builder builder = new AlertDialog.Builder(AvaliarActivity.this);
                        builder.setTitle("ERRO!");
                        builder.setMessage("Por favor, selecione um item na Primeira pergunta");

                        AlertDialog dialog = builder.create();
                        dialog.show();

                    }

                    if (!rbPer.isChecked() && !rbRisc.isChecked() && !rbTrinc.isChecked()) {


                        final AlertDialog.Builder builder = new AlertDialog.Builder(AvaliarActivity.this);
                        builder.setTitle("ERRO!");
                        builder.setMessage("Por favor, selecione um item na Segunda pergunta");

                        AlertDialog dialog = builder.create();
                        dialog.show();

                    }

                    if (!rbPerf.isChecked() && !rbAmass.isChecked() && !rbDesga.isChecked()) {


                        final AlertDialog.Builder builder = new AlertDialog.Builder(AvaliarActivity.this);
                        builder.setTitle("ERRO!");
                        builder.setMessage("Por favor, selecione um item na Terceira pergunta");

                        AlertDialog dialog = builder.create();
                        dialog.show();

                    }
                }
            }


        });

    }
}

