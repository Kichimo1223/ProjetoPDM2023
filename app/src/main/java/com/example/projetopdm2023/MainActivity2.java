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

        playerid = findViewById(R.id.playerid);
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
                    criatura = new Criatura(-1,
                            nomecria.getText().toString(),
                            Integer.parseInt(vd.getText().toString()));
                    boolean sucesso = Bancodds.adicionarCriatura(criatura);
                    Bancodds.getListaCriatura();
                    Toast.makeText(MainActivity2.this, "Sucesso:" + sucesso, Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity2.this, "Erro na conversão de uma String para int: Idade não corresponde a número!", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity2.this, "Erro na criação do usuário!", Toast.LENGTH_LONG).show();
                }
            }
        });

        adicionarbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mostrarCriaturanalistview(Bancodds);

                Toast.makeText(MainActivity2.this, "Lista de usuários preenchida com sucesso", Toast.LENGTH_SHORT).show();


            }
        });
        preenchimento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                System.out.println("Captou click na lista!");
                Criatura usuarioClicado = (Criatura) parent.getItemAtPosition(position);
                boolean excluiu = Bancodds.excluirCriatura(usuarioClicado);

                mostrarCriaturanalistview(Bancodds);

                Toast.makeText(MainActivity2.this, "Usuário excluído(" + excluiu + "):" + usuarioClicado.toString(), Toast.LENGTH_SHORT).show();


            }
        });

        atualizarcria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aqui acontece a ação

                //Declaração de um objeto usuário da (nossa) classe Usuário
                Criatura criatura = null;//null para inicializar

                //Bloco try para "tentar" executar as ações esperadas. O catch é para "remediar" ou "avisar" algo que não foi realizado no bloco try como esperado.
                try {
                    criatura = new Criatura(Integer.parseInt(nomecria.getText().toString()), nomecria.getText().toString(), Integer.parseInt(vd.getText().toString()));

                    boolean sucesso = Bancodds.atualizarCriatura(criatura);

                    mostrarCriaturanalistview(Bancodds);
                    Toast.makeText(MainActivity2.this, "Sucesso:" + sucesso, Toast.LENGTH_SHORT).show();

                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity2.this, "Erro na conversão de uma String para int: Idade não corresponde a número!", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity2.this, "Erro na criação do usuário!", Toast.LENGTH_LONG).show();
                    criatura = new Criatura(-1, "erro", 0);
                }

            }
        });


    }

    private void mostrarCriaturanalistview(Bancodds bancodds) {
        criaturaArrayAdapter = new ArrayAdapter<Criatura>(MainActivity2.this,
                android.R.layout.simple_list_item_1, bancodds.getListaCriatura());//Dentro de <> está o tipo de objeto que será adicionado na lista
        preenchimento.setAdapter(criaturaArrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
