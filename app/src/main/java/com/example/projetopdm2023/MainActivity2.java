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
    vd = findViewById(R.id.elemento);
    preenchimento = findViewById(R.id.preenchimento);

   adcnomecria.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Criatura criatura = null;

       }
   }
    }