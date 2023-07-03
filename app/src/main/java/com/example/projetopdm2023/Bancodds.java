package com.example.projetopdm2023;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Bancodds extends SQLiteOpenHelper {

    protected static final String TABELA_USUARIO = "TABELA_USUARIO";
    protected static final String USUARIO_ID = "ID";
    protected static final String USUARIO_NOME = "USUARIO_NOME";
    protected static final String USUARIO_IDADE = "USUARIO_IDADE";


    public Bancodds(@Nullable Context context) {

        super(context, "Bancodds", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String statement = "CREATE TABLE " + TABELA_USUARIO +
                " (" + USUARIO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USUARIO_NOME + " TEXT, " + USUARIO_IDADE + " INT)";


        db.execSQL(statement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean adicionarUsuario(Usuario usuario) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(USUARIO_NOME, usuario.getNomeUsuario());
        contentValues.put(USUARIO_IDADE, usuario.getIdadeUsuario());

             long inserirSucedido = db.insert(TABELA_USUARIO, null, contentValues);
        db.close();

        return inserirSucedido != -1;


    }


    public boolean atualizarUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(USUARIO_NOME, usuario.getNomeUsuario());
        contentValues.put(USUARIO_IDADE, usuario.getIdadeUsuario());
        contentValues.put(USUARIO_ID, usuario.getIdUsuario());


        long atualizarSucedido = db.update(TABELA_USUARIO,
                contentValues,
                USUARIO_ID + "=" + usuario.getIdUsuario(),
                null);
        db.close();


        return atualizarSucedido != -1;


    }

    public List<Usuario> getListaUsuarios() {//Para importar List, pode ser usado o atalho com Alt+Enter (para escolher a ação) ou Shift+Alt+Enter (para pegar o pacote sugerido pela ferramenta Android Studio). Tem que ser do pacote "java.util.List"

        List<Usuario> listaUsuarios = new ArrayList<>();

        String queryStatement = "SELECT * FROM " + TABELA_USUARIO;

        SQLiteDatabase db = this.getReadableDatabase();


        try (Cursor cursor = db.rawQuery(queryStatement, null)) {


            if (cursor.moveToFirst()) {
                do {
                    int usuarioCod = cursor.getInt(0);
                    String usuarioNome = cursor.getString(1);
                    int usuarioIdade = cursor.getInt(2);


                    Usuario usuario = new Usuario(usuarioCod, usuarioNome, usuarioIdade);
                    listaUsuarios.add(usuario);
                } while (cursor.moveToNext());
            } else {

            }


        }
        db.close();

        return listaUsuarios;
    }

    public boolean excluirUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString =
                "DELETE FROM " + TABELA_USUARIO + " WHERE " + USUARIO_ID + " = " + usuario.getIdUsuario();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }

    }
}
