package com.example.camellap.ViewModel;

public class ClaseContratante extends ClasePersona {

    //atributos
    public boolean estadoPago ;
    public String infoEvento;

    //constructor de valores por defecto
    public ClaseContratante (){
        this.estadoPago = false;
        this.infoEvento = "Sin evento agendado";
    }
    //constructor con para metros

    public ClaseContratante(String nombre, String contacto, String identificacion, boolean estadoPago, String infoEvento){
        super(nombre, identificacion, contacto);
        this.estadoPago = estadoPago;
        this.infoEvento = infoEvento;
    }
    //getters and setters

    public boolean isEstadoPago() {
        return estadoPago;
    }
}
