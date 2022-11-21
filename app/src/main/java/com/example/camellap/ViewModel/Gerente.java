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
    public ArrayList<ClaseEvento> eventos = new ArrayList<>();
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
    public void nuevoEvento(int costo, String lugar, String tematica, String fecha){
        eventos.add(new ClaseEvento(costo,lugar,tematica,fecha));
        Log.d("ActivityMain","Nuevo Evento");
    }

    public void nuevoContratante(String nombreC, String contacto, String identificacion, boolean estadoPagoC){
        contratantes.add(new ClaseContratante(nombreC,contacto,identificacion,estadoPagoC));
        Log.d("ActivityMain","Nuevo Contratante");
    }

    public void nuevoPersonal(String nombreP, String contactoP,String apodoP, String experP, String identificacionP, String cargoP){
        personal.add(new ClasePersonal(nombreP,contactoP,apodoP,experP,identificacionP,cargoP));
        Log.d("ActivityMain","Nuevo Personal");
    }

    public void crearInventario(String nombreM, int cantM){
        inventario.add(new ClaseInventario(nombreM,cantM));
        Log.d("ActivityMain","Nuevo Inventario");
    }

}
