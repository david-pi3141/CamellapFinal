package com.example.camellap.ViewModel;

public class ClaseContratante extends ClasePersona {

    //atributos
    public boolean estadoPago ;

    //constructor con para metros

    public ClaseContratante(String nombre, String contacto, String identificacion, boolean estadoPago){
        super(nombre, identificacion, contacto);
        this.estadoPago = estadoPago;
    }
    //getters and setters

    public boolean isEstadoPago() {
        return estadoPago;
    }
}
