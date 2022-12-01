package com.example.camellap.ViewModel;

public class ClaseEvento{

    //atributos
    int costo;
    boolean estadoPago;
    String lugar;
    String tematica;
    String fecha;
    String personal;
    String inventario;
    String contratante;

    //constructores
    //constructor con parametros
    public ClaseEvento(int costo, String lugar, String tematica, String fecha){
        this.costo = costo;
        this.lugar = lugar;
        this.tematica = tematica;
        this.fecha = fecha;
        this.contratante = "Por definir";
        this.inventario = "Por definir";
        this.personal = "Por definir";
        this.estadoPago = true;
    }

    //getters y setters
    public String getPersonal() {
        return personal;
    }
    public void setPersonal(String personal) {
        this.personal = personal;
    }
    public String getInventario() {
        return inventario;
    }
    public void setInventario(String inventario) {
        this.inventario = inventario;
    }
    public String getContratante() {
        return contratante;
    }
    public void setContratante(String contratante) {
        this.contratante = contratante;
    }
    public int getCosto() {
        return costo;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }
    public boolean getEstadoPago() {
        return estadoPago;
    }
    public void setEstadoPago(boolean estadoPago) {
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