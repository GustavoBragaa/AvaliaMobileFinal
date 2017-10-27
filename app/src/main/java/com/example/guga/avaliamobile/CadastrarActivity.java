package com.example.guga.avaliamobile;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guga.avaliamobile.DAO.UsuarioDAO;

public class CadastrarActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        ActionBar ab = getSupportActionBar();
        ab.hide();

        openHelper = new UsuarioDAO(this);
        //Recebendo Id's
        final EditText txtNome = (EditText) findViewById(R.id.cadastrar_edt_nome);
        final EditText txtEmail = (EditText) findViewById(R.id.cadastrar_edt_email);
        final EditText txtSenha = (EditText) findViewById(R.id.cadastrar_edt_password);
        Button btnCadastrar = (Button) findViewById(R.id.cadastrar_btn_cadastrar);
        Button btnCancelar = (Button) findViewById(R.id.cadastrar_btn_cancelar);

        //Função do botão Cagastrar
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = openHelper.getWritableDatabase();

                //Passando os dados informados para String
                String nome = txtNome.getText().toString();
                String email = txtEmail.getText().toString();
                String senha = txtSenha.getText().toString();

                //Validando se a senha inserida não está em branco
                if (senha.isEmpty() || senha.equals(" ".trim())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CadastrarActivity.this);
                    builder.setTitle("ERRO!");
                    builder.setMessage("Senha esta em branco, por favor reveja.");

                    AlertDialog dialog = builder.create();
                    dialog.show();


                }
                //Validando se o email inserido não está em branco
                if (email.isEmpty() || email.equals("".trim())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CadastrarActivity.this);
                    builder.setTitle("ERRO!");
                    builder.setMessage("Email esta em branco, por favor reveja.");

                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
                //Validando se o nome inserido não está em branco
                if (nome.isEmpty() || nome.equals(" ".trim())) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(CadastrarActivity.this);
                    builder.setTitle("ERRO!");
                    builder.setMessage("Nome  esta em branco, por favor reveja.");

                    AlertDialog dialog = builder.create();
                    dialog.show();


                }
                // Verificando se todos os campos são diferentes de nullo, e acrescentando ao banco
                if (!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty()) {
                    insereUsuario(nome, email, senha);


                    //Caixa de Mensagem
                    final AlertDialog.Builder builder = new AlertDialog.Builder(CadastrarActivity.this);
                    builder.setTitle("Parabens!");
                    builder.setMessage("Seu novo Usuario foi cadastrado com sucesso!!!");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
        // Botão cancelar chama tela de login
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CadastrarActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // Metodo que ira pegar os dados inseridos e mandar para o banco
    public void insereUsuario(String nome, String email, String senha) {
        ContentValues values = new ContentValues();
        values.put(UsuarioDAO.COLUNA_NOME, nome);
        values.put(UsuarioDAO.COLUNA_EMAIL, email);
        values.put(UsuarioDAO.COLUNA_SENHA, senha);
        long id = db.insert(UsuarioDAO.TABELA_NOME, null, values);

    }

}


