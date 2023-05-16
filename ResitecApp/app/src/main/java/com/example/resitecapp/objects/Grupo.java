package com.example.resitecapp.objects;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;

public class Grupo implements Serializable {

    public Grupo(int id_proyecto, String acronimo, String titulo, List<Alumno> alumnos, Asesor asesor){
        this.id_proyecto = id_proyecto;
        this.acronimo = acronimo;
        this.titulo = titulo;
        this.alumnos = alumnos;
        this.asesor = asesor;
    }
    private int id_proyecto;
    private String acronimo;
    private String titulo;
    private List<Alumno> alumnos;
    private Asesor asesor;

    public String getNomProyecto() {
        return titulo;
    }

    public String getAcronimoProyecto() {
        return acronimo;
    }

    public void setAcronimoProyecto(String acronimoProyecto) {
        this.acronimo = acronimoProyecto;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(Asesor asesor) {
        this.asesor = asesor;
    }


    public void setNomProyecto(String nomProyecto) {
        this.titulo = nomProyecto;
    }

    public int getIdProyecto() {
        return id_proyecto;
    }

    public void setIdProyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }
}
