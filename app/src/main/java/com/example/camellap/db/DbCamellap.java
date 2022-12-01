package com.example.camellap.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

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
}
