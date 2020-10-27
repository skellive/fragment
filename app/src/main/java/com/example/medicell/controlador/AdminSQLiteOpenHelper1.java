package com.example.medicell.controlador;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
interface AdminSQLiteOpenHelper1 extends AutoCloseable {

    void onCreate(SQLiteDatabase db, SQLiteDatabase db2);
}
