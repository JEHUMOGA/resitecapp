package com.example.resitecapp.objects;

import java.util.List;

public class Grupo {
    private int idGrupo;
    private String nomProyecto;
    private String acronimoProyecto;
    private List<Alumno> alumnos;
    private String asesorExt;
    private Asesor asesorInterno;

    public String getNomProyecto() {
        return nomProyecto;
    }

    public String getAcronimoProyecto() {
        return acronimoProyecto;
    }

    public void setAcronimoProyecto(String acronimoProyecto) {
        this.acronimoProyecto = acronimoProyecto;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public String getAsesorExt() {
        return asesorExt;
    }

    public void setAsesorExt(String asesorExt) {
        this.asesorExt = asesorExt;
    }

    public Asesor getAsesorInterno() {
        return asesorInterno;
    }

    public void setAsesorInterno(Asesor asesorInterno) {
        this.asesorInterno = asesorInterno;
    }

    public void setNomProyecto(String nomProyecto) {
        this.nomProyecto = nomProyecto;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }
}
