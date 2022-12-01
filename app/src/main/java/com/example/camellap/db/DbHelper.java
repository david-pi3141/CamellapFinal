package com.example.camellap.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
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
                "nombre_material TEXT NOT NULL," +
                "cantidad_material INTEGER NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CONTRATANTE + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombrecontratante TEXT NOT NULL," +
                "contatocontratante TEXT NOT NULL," +
                "identificacioncontratante INTEGER NOT NULL," +
                "estadopagocontratante TEXT NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_FINANZAS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "cantidad INTEGER NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PERSONAL + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombrepersonal TEXT NOT NULL," +
                "contactopersonal TEXT NOT NULL," +
                "apodopersonal TEXT NOT NULL," +
                "experienciapersonal TEXT NOT NULL," +
                "identificacionpersonal INTEGER NOT NULL," +
                "cargopersonal TEXT NOT NULL)");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EVENTO + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "fecha TEXT NOT NULL," +
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
