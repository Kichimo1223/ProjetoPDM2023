package com.example.projetopdm2023;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Bancodds extends SQLiteOpenHelper {

    protected static final String ID = "ID";
    protected static final String Tblcria = "Tblcria";
    protected static final String nomecria = "nomecria";
    protected static final String element = "element";
    protected static final String VdCria = "VdCria";


    public Bancodds(@Nullable Context context) {

        super(context, "Bancodds", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String statement = "CREATE TABLE " + Tblcria +
                " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + nomecria + " TEXT, " + element + " TEXT, " + VdCria + " INT)";


        db.execSQL(statement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean adicionarCriatura(Criatura criatura) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(nomecria, criatura.getNomeCriatura());
        contentValues.put(element, criatura.getNomedoelemet());
        contentValues.put(VdCria, criatura.getVdCriatura());

             long inserirSucedido = db.insert(Tblcria, null, contentValues);
        db.close();

        return inserirSucedido != -1;


    }


    public boolean atualizarCriatura(Criatura criatura) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, criatura.getIdCriatura());
        contentValues.put(nomecria, criatura.getNomeCriatura());
        contentValues.put(element, criatura.getNomedoelemet());
        contentValues.put(VdCria, criatura.getVdCriatura());


        long atualizarSucedido = db.update(Tblcria,
                contentValues,
                ID + "=" + criatura.getIdCriatura(),
                null);
        db.close();


        return atualizarSucedido != -1;


    }

    public List<Criatura> getListaCriatura() {//Para importar List, pode ser usado o atalho com Alt+Enter (para escolher a ação) ou Shift+Alt+Enter (para pegar o pacote sugerido pela ferramenta Android Studio). Tem que ser do pacote "java.util.List"

        List<Criatura> listaCriatura = new ArrayList<>();

        String queryStatement = "SELECT * FROM " + Tblcria;

        SQLiteDatabase db = this.getReadableDatabase();


        try (Cursor cursor = db.rawQuery(queryStatement, null)) {


            if (cursor.moveToFirst()) {
                do {
                    int ID =cursor.getInt(0);
                    String nmcria = cursor.getString(1);
                    String element = cursor.getString(2);
                    int valords = cursor.getInt(3);


                    Criatura criatura = new Criatura(ID, nmcria, element, valords);
                    listaCriatura.add(criatura);
                } while (cursor.moveToNext());
            } else {

            }


        }
        db.close();

        return listaCriatura;
    }

    public boolean excluirCriatura(Criatura criatura) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString =
                "DELETE FROM " + Tblcria + " WHERE " + ID + " = " + criatura.getIdCriatura();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }

    }
}
