package com.example.camellap.ViewModel;

import android.util.Log;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

public class Gerente {
    String nombre;
    public ArrayList<ClaseEvento> eventos = new ArrayList<ClaseEvento>();
    public ArrayList<ClaseContratante> contratantes = new ArrayList<ClaseContratante>();
    public ArrayList<ClasePersonal> personal = new ArrayList<ClasePersonal>();
    public ArrayList<ClaseInventario> inventario = new ArrayList<ClaseInventario>();


    public Gerente(String nombre) {
        this.nombre = nombre;
    }
//getters y seters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //metodos
    public void nuevoEvento(float costo, String lugar, String tematica, String fecha){
        eventos.add(new ClaseEvento(costo,lugar,tematica,fecha));
        Log.d("ActivityMain","Hola");
    }
}
