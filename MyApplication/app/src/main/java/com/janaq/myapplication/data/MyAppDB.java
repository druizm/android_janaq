package com.janaq.myapplication.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DavidM on 18/03/2016.
 */
public class MyAppDB extends SQLiteOpenHelper {

    private String sql_create_productos = "CREATE TABLE productos (id INTEGER PRIMARY KEY, " +
            "nombre TEXT, descripcion TEXT, precio DECIMAL, imagen TEXT, categoria TEXT );";

    private String sql_drop_productos = "DROP TABLE IF EXISTS productos;";

    public MyAppDB (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sql_create_productos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(sql_drop_productos);

        db.execSQL(sql_create_productos);

    }
}
