package com.example.guga.avaliamobile.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.guga.avaliamobile.R;

public class LoginSuccessActivity extends AppCompatActivity {
    private TextView txtNome;
    private TextView txtEmail;
    private Button btAvaliar;
    private Button btFiliais;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);


        //Recebendo Id das text View
        txtNome = (TextView) findViewById(R.id.txt_success_name);
        txtEmail = (TextView) findViewById(R.id.txt_success_email);

        //Mostrando Nome de Usuario e email informado no cadastro
        Intent intent = getIntent();
        String loginNome = intent.getStringExtra("nome");
        String loginEmail = intent.getStringExtra("email");
        txtNome.setText("Seja Bem Vindo, " + loginNome);
        txtEmail.setText(loginEmail);

        //Recebendo Id dos botões
        btAvaliar = (Button) findViewById(R.id.btAvaliar);
        btFiliais = (Button) findViewById(R.id.btFiliais);

        //Chamando activity

        btAvaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ChamaAvaliar = new Intent(LoginSuccessActivity.this, SelecionarAparelhoActivity.class);
                startActivity(ChamaAvaliar);
            }
        });
        //Chamando Activity
        btFiliais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ChamaFiliais = new Intent(LoginSuccessActivity.this, FiliaisActivity.class);
                startActivity(ChamaFiliais);
            }
        });


    }
}
