package com.example.camellap.db;

import static com.example.camellap.ui.MainActivity.gerente;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.camellap.ViewModel.ClaseInventario;

public class DbCamellap extends DbHelper {

    Context context;

    public DbCamellap(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarMaterial(String nombre_material, Integer cantidad_material) {

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre_material", nombre_material);
            values.put("cantidad_material", cantidad_material);


            id = db.insert(TABLE_INVENTARIO, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;

    }
    public long insertarEvento(String fecha, String lugar, String costo, String tematica) {

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("fecha", fecha);
            values.put("lugar", lugar);
            values.put("costo", costo);
            values.put("tematica", tematica);


            id = db.insert(TABLE_EVENTO, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;

    }
    public long insertarContratante(String nombrecontratante, String contatocontratante, String identificacioncontratante, String estadopagocontratante) {

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombrecontratante", nombrecontratante);
            values.put("contatocontratante", contatocontratante);
            values.put("identificacioncontratante", identificacioncontratante);
            values.put("estadopagocontratante", estadopagocontratante);


            id = db.insert(TABLE_CONTRATANTE, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;

    }
    public long insertarPersonal(String nombrepersonal, String contactopersonal, String apodopersonal, String experienciapersonal, String identificacionpersonal, String cargopersonal) {

        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombrepersonal", nombrepersonal);
            values.put("contactopersonal", contactopersonal);
            values.put("apodopersonal", apodopersonal);
            values.put("experienciapersonal", experienciapersonal);
            values.put("identificacionpersonal", identificacionpersonal);
            values.put("cargopersonal", cargopersonal);


            id = db.insert(TABLE_PERSONAL, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;

    }

    public void  obtenerInfo() {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();


        ClaseInventario inventarios;
        Cursor cursorInventario;

        cursorInventario = db.rawQuery("SELECT * FROM " + TABLE_INVENTARIO, null);

        if (cursorInventario.moveToFirst()) {
            do {
                inventarios = new ClaseInventario((cursorInventario.getString(1)), cursorInventario.getInt(2));

                gerente.inventario.add(inventarios);
            } while (cursorInventario.moveToNext());
        }

        cursorInventario.close();

    }
}
