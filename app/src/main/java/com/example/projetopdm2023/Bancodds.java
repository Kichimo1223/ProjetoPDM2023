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

    public Bancodds(@Nullable Context context,) {
        super(context, "Criat", null, 3.4.4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        public static String getCreateTableCriatura(){

        StingBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE criat (");
        sql.append(" codCriatuta INTEGER PRIMARY KEY AUTOINCREMENT");
        sql.append("NOT NULL,");
        sql.append("nomecria    TEXT    NOT NULL,");
        sql.append("element     TEXT    NOT NULL,");
        sql.append("VdCria      NUMERIC NOT NULL");

                return sql.toString();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
