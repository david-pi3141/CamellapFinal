package com.example.camellap.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "Camellap.db";
    public static final String TABLE_INVENTARIO = "t_inventario";
    public static final String TABLE_CONTRATANTE = "t_contratante";
    public static final String TABLE_FINANZAS = "t_finanzas";
    public static final String TABLE_PERSONAL = "t_personal";
    public static final String TABLE_EVENTO = "t_evento";





    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_INVENTARIO + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre_elemento TEXT NOT NULL," +
                "cantidad INTEGER NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CONTRATANTE + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre_contratante TEXT NOT NULL," +
                "contacto_contratante TEXT NOT NULL," +
                "identificacion_contratante INTEGER NOT NULL," +
                "estado_pago)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_FINANZAS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "cantidad INTEGER NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PERSONAL + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre_personal TEXT NOT NULL," +
                "contacto_personal TEXT NOT NULL," +
                "apodo TEXT NOT NULL," +
                "experiencia TEXT NOT NULL," +
                "identificacion_personal INTEGER NOT NULL," +
                "cargo TEXT NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EVENTO + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "fecha_evento TEXT NOT NULL," +
                "lugar TEXT NOT NULL, " +
                "costo TEXT NOT NULL, " +
                "tematica TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_INVENTARIO);
        onCreate(sqLiteDatabase);

    }
}
