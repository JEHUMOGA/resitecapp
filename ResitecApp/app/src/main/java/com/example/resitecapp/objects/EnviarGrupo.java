package com.example.resitecapp.objects;

import java.util.ArrayList;
import java.util.List;

public class EnviarGrupo {
    private String asesor;
    private List<Alumno> alumnos;

    public String getAsesor() {
        return asesor;
    }

    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
