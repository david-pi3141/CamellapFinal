package com.example.camellap.ViewModel;

import java.util.Date;

public class ClaseEvento{

    //atributos
    float costo;
    float estadoPago;
    String lugar;
    String tematica;
    String fecha;

    //constructores
    //constructor con parametros
    public ClaseEvento(float costo, String lugar, String tematica, String fecha){
        this.costo = costo;
        this.lugar = lugar;
        this.tematica = tematica;
        this.fecha = fecha;

    }

    //getters y setters
    public float getCosto() {
        return costo;
    }
    public void setCosto(float costo) {
        this.costo = costo;
    }
    public float getEstadoPago() {
        return estadoPago;
    }
    public void setEstadoPago(float estadoPago) {
        this.estadoPago = estadoPago;
    }
    public String getLugar() {
        return lugar;
    }
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    public String getTematica() {
        return tematica;
    }
    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
    public String getFecha() {return fecha;}
    public void setFecha(String fecha) {this.fecha = fecha;}
    //metodos
}