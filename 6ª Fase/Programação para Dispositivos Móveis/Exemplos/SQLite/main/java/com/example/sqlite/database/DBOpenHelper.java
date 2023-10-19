package com.example.sqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sqlite.database.model.PessoaModel;

public class DBOpenHelper extends SQLiteOpenHelper {
    private static final String
    DATABASE_NOME = "unesc.db";

    private static final int
    DATABASE_VERSAO = 1;

    public DBOpenHelper(Context context) {
        super(context, DATABASE_NOME, null, DATABASE_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(PessoaModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // i = oldVersion
        // i1 = newVersion

        sqLiteDatabase.execSQL(PessoaModel.DROP_TABLE);
        sqLiteDatabase.execSQL(PessoaModel.CREATE_TABLE);
    }

}
