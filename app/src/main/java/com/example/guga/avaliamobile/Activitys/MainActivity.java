package com.example.guga.avaliamobile.Activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guga.avaliamobile.DAO.AvaliacoesDAO;
import com.example.guga.avaliamobile.Factory.UsuarioFactory;
import com.example.guga.avaliamobile.DAO.Usuario;
import com.example.guga.avaliamobile.R;
import com.example.guga.avaliamobile.Util.BancoUsuarios;

public class MainActivity extends AppCompatActivity {

    private EditText txtUsuario;
    private EditText txtSenha;
    private Button btnEntrar;
    private TextView txtCadastrar;
    SQLiteOpenHelper dbHelper;
    SQLiteDatabase db;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getSupportActionBar();
        ab.hide();

        //Pegando Id's
        txtUsuario = (EditText) findViewById(R.id.main_edt_email);
        txtSenha = (EditText) findViewById(R.id.main_edt_password);
        txtCadastrar = (TextView) findViewById(R.id.main_txt_cadastrar);
        btnEntrar = (Button) findViewById(R.id.main_btn_entrar);

        dbHelper = new UsuarioFactory(this);
        db = dbHelper.getWritableDatabase();
        final Usuario usuario = new Usuario();

        //Função do botão Entrar
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {


                    //Transformando dados em String
                    usuario.setEmail(txtUsuario.getText().toString());
                    usuario.setSenha(txtSenha.getText().toString());

                    //Pegando cursosr para buscar dados no banco de dados
                    cursor = db.rawQuery("SELECT *FROM " + BancoUsuarios.TABELA_NOME + " WHERE " +
                                    BancoUsuarios.COLUNA_EMAIL + "=? AND " +
                                    BancoUsuarios.COLUNA_SENHA + "=?",
                            new String[]{usuario.getEmail(), usuario.getSenha()});


                    if (cursor != null) {
                        if (cursor.getCount() > 0) {

                            cursor.moveToFirst();

                            //Se encontrar os dados informados pelo usuario, colocar dentro das variaveis em string
                            String intentnome = cursor.getString(cursor.getColumnIndex(BancoUsuarios.COLUNA_NOME));
                            String intentemail = cursor.getString(cursor.getColumnIndex(BancoUsuarios.COLUNA_EMAIL));

                            //Mostrar mensagem
                            Toast.makeText(MainActivity.this, "Ola!", Toast.LENGTH_SHORT).show();

                            //Chamando nova Activity
                            Intent intent = new Intent(MainActivity.this, LoginSuccessActivity.class);

                            //Enviando dados para a proxima acttivity
                            intent.putExtra("nome", intentnome);
                            intent.putExtra("email", intentemail);
                            startActivity(intent);

                            //fechando banco
                            db.close();
                            finish();

                        } else {
                            //Mensagem de erro ao não encontrar dados informados pelo cliente
                            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setCancelable(false);
                            builder.setTitle("Alerta");
                            builder.setMessage("Nome de Usuario ou senha esta incorreto");
                            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });

                            AlertDialog dialog = builder.create();
                            dialog.show();

                        }
                    }


                    } catch (Exception error)

                    { //Mensagem de Erro da Exception
                        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setCancelable(false);
                        builder.setTitle("ERRO ");
                        builder.setMessage("Falha ao consultar registros");
                        builder.setPositiveButton("OK!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });

                        AlertDialog dialog = builder.create();
                        dialog.show();


                    } finally

                    {
                        db.close();
                    }
                }
            });

        //Text View que chama activity de cadastro
        txtCadastrar.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CadastrarActivity.class);
                startActivity(intent);
            }
        });


    }
}
