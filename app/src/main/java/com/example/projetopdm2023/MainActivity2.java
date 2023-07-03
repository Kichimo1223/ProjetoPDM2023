package com.example.projetopdm2023;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    public Button adcnomecria;
    public Button adicionarbc;
    public Button atualizarcria;
    public EditText nomecria;
    public EditText elemento;
    public EditText vd;

    public EditText playerid;
    public ListView preenchimento;

    ArrayAdapter criaturaArrayAdapter;
    Bancodds Bancodds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        adcnomecria = findViewById(R.id.adcnomecria);
        adicionarbc = findViewById(R.id.adicionarbc);
        atualizarcria = findViewById(R.id.atualizarcria);
        nomecria = findViewById(R.id.nomecria);
        elemento = findViewById(R.id.elemento);
        vd = findViewById(R.id.vd);
        preenchimento = findViewById(R.id.preenchimento);

        adcnomecria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Criatura criatura = null;
                try {
                    criatura = new criatura(-1,
                            nomecria.getText().toString(),
                            Integer.parseInt(vd.getText().toString()));
                    boolean sucesso = Bancodds.adicionarUsuario(criatura);
                    mostrarUsuariosNaListView(Bancodds);
                    Toast.makeText(MainActivity.this, "Sucesso:" + sucesso, Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Erro na conversão de uma String para int: Idade não corresponde a número!", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Erro na criação do usuário!", Toast.LENGTH_LONG).show();
                }
            }
        });
        protected static final String ID = "ID";
        protected static final String Tblcria = "Tblcria";
        protected static final String nomecria = "nomecria";
        protected static final String element = "element";
        protected static final String VdCria = "VdCria";