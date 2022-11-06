package com.example.camellap.ViewModel;

public class ClaseEvento{

    //atributos
    float costo;
    float estadoPago;
    String lugar;
    String tematica;
    String fecha;

    //constructores
    //constructopr por defecto
    public ClaseEvento(){
        this.costo = 1000000 ;
        this.estadoPago = 0 ;
        this.lugar = "Salon platino Banquetes y recepciones la excelencia";
        this.tematica = "Sin tematica establecida";
        this.fecha = "Sin fecha establecida"; //lo deje string porque no se que significa date osea se que date es fecha pero no se como escribirlo en codigo
    }
    //constructor con parametros
    public ClaseEvento(float costo,float estadoPago, String lugar, String tematica, String fecha){
        this.costo = costo;
        this.estadoPago = estadoPago;
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
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    //metodos
}