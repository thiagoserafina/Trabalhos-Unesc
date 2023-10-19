package com.example.sqlite.database.dao;

import android.database.sqlite.SQLiteDatabase;

import com.example.sqlite.database.DBOpenHelper;

public abstract class AbstrataDAO {
    protected SQLiteDatabase db;
    protected DBOpenHelper db_helper;

    protected void Open() {
        db = db_helper.getWritableDatabase();
    }

    protected void Close() {
        db_helper.close();
    }
}
