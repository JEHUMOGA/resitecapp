package com.example.resitecapp.objects;

public class Administrador {
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String email;

    public Administrador(String nombre, String apePaterno, String apeMaterno, String email){
        this.apeMaterno = apeMaterno;
        this.apePaterno = apePaterno;
        this.email = email;
        this.nombre = nombre;
    }

}
