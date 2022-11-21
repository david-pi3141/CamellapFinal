package com.example.camellap.ViewModel;

public class ClasePersona{
    //atributos
    protected String nombre;
    protected String contacto;
    protected String identificacion;

    //constructores
    //por default
    public ClasePersona(){
        this.nombre = "Desconocido";
        this.contacto = "Sin contacto";
        this.identificacion = "Sin identificacion";
    }
    //constructor con parametros
    public ClasePersona(String nombre, String contacto, String identificacion){
        this.nombre = nombre;
        this.contacto =  contacto;
        this.identificacion = identificacion;
    }
//Metodos
//getters y setters
    public String getNombre(){
        return nombre;
    }
    public String getContacto(){
        return contacto;
    }
    public String getIdentificacion(){
        return identificacion;
    }
    public void setNombre( String nombre){
        this.nombre = nombre;
    }
    public void setContacto( String contacto){
        this.contacto = contacto;
    }
    public void setIdentificacion(String identificacion){
        this.identificacion = identificacion;
    }
}
