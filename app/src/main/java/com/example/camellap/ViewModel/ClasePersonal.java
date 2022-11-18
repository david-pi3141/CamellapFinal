package com.example.camellap.ViewModel;

public class ClasePersonal extends ClasePersona{

    //atributos
    public String apodo;
    public String experiencia;
    public String cargo;

    //constructores
    //por default
    public ClasePersonal(){
        this.apodo = "Desconocido";
        this.experiencia = "Sin contacto";

        this.cargo = "Sin cargo";
    }

    //constructor con parametros
    public ClasePersonal(String nombre, String contacto, String apodo, String experiencia,String identificacion, String cargo){
        super (nombre, contacto,identificacion);
        this.apodo = apodo;
        this.experiencia = experiencia;
        this.identificacion =  identificacion;
        this.cargo = cargo;
    }

    //Metodos

    //getters y setters
    public String getApodo(){
        return apodo;
    }
    public String getExperiencia(){
        return experiencia;
    }
    public String getidentificacion(){
        return identificacion;
    }
    public String getCargo(){
        return cargo;
    }
    public void setApodo(String apodo){
        this.apodo = apodo;
    }
    public void setExperiencia(String experiencia){
        this.experiencia = experiencia;
    }
    public void setIdentificacion(String identificacion){
        this.identificacion = identificacion;
    }
    public void setCargo(String cargo ){
        this.cargo = cargo;
    }

}

