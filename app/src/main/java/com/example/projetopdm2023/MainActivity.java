package com.example.projetopdm2023;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Button;
import javax.security.auth.callback.PasswordCallback;

public class MainActivity extends AppCompatActivity {

    public EditText Nomeusuario;
    public EditText Sera;
    public Button Registrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nomeusuario = findViewById(R.id.Nomeusuario);
        Sera = findViewById(R.id.Sera);
        Registrar = findViewById(R.id.Registrar);
    }
}