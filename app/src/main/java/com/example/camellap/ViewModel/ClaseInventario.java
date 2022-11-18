package com.example.camellap.ViewModel;

public class ClaseInventario {
    String nombreElemnto;
    int cantidad;

    public ClaseInventario(String nombreElemnto, int cantidad) {
        this.nombreElemnto = nombreElemnto;
        this.cantidad = cantidad;
    }

    public String getNombreElemnto() {
        return nombreElemnto;
    }

    public void setNombreElemnto(String nombreElemnto) {
        this.nombreElemnto = nombreElemnto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
