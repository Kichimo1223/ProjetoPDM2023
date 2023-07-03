package com.example.projetopdm2023;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Bancodds extends SQLiteOpenHelper {

    protected static final String TABELA_USUARIO = "TABELA_USUARIO";
    protected static final String USUARIO_ID = "ID";
    protected static final String USUARIO_NOME = "USUARIO_NOME";
    protected static final String USUARIO_IDADE = "USUARIO_IDADE";
}
