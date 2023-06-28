package com.example.projetopdm2023;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText nomeusuario;
    public EditText sera;
    public Button registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeusuario = findViewById(R.id.nomeusuario);
        sera = findViewById(R.id.sera);
        registrar = findViewById(R.id.registrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = nomeusuario.getText().toString();
                String senha = sera.getText().toString();

                if(nome.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Coloque todas as informações", Toast.LENGTH_SHORT).show();
                }else{
                    if (senha.equals("0413")) {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Senha incorreta, você é mesmo um membro?", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });

    }
}
