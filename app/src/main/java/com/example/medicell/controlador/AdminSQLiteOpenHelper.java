package com.example.medicell.controlador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE diagnostico_user("+
                "id_user TEXT,"+
                "nombre_apellido TEXT,"+
                "sintomas_presentados TEXT,"+
                "Diagnostico TEXT,"+
                "Enfermedades_presentadas TEXT);"
        );

        db.execSQL("CREATE TABLE sintomas("+
                "sintomas_presentados TEXT"+
                ");"
        );

        db.execSQL("CREATE TABLE enfermedades(id_enfermedades TEXT, nombre_enfermedades TEXT, enfermedades_has_diagnostico TEXT )");




    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void borrar_diagnostico(SQLiteDatabase db) {
        db.execSQL("DELETE FROM diagnostico_user");
    }
}