package com.example.resitecapp.objects;

public class Alumno {
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String noControl;
    private String carrera;
    private String email;

    public Alumno(String nombre, String apePaterno, String apeMaterno, String noControl, String carrera, String email){
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.noControl = noControl;
        this.carrera = carrera;
        this.email = email;
    }
    public Alumno(){
        this("Jesus Humberto", "Moreno", "Galvez", "17171436", "Ing. En sistemas Computacionales", "17171436@itculiacan.edu.mx");
    }

    public String getNombre(){
        return nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public String getNoControl() {
        return noControl;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getEmail() {
        return email;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNoControl(String noControl) {
        this.noControl = noControl;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
