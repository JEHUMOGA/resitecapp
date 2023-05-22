package com.example.resitecapp.objects;

public class Dictamen {
    private Empresa empresa;
    private Proyecto proyecto;
    private AsesorExterno asesorExterno;
    private Alumno alumno;

    public Dictamen(Empresa empresa, Proyecto proyecto, AsesorExterno asesorExterno, Alumno alumno){
        this.empresa = empresa;
        this.proyecto = proyecto;
        this.asesorExterno = asesorExterno;
        this.alumno = alumno;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public AsesorExterno getAsesorExterno() {
        return asesorExterno;
    }

    public void setAsesorExterno(AsesorExterno asesorExterno) {
        this.asesorExterno = asesorExterno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
