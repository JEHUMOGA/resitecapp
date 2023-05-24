package com.example.resitecapp.objects;

public class Dictamen {
    private Empresa empresa;
    private Proyecto proyecto;
    private AsesorExterno asesorexterno;
    private Alumno alumno;

    public Dictamen(Empresa empresa, Proyecto proyecto, AsesorExterno asesorExterno, Alumno alumno){
        this.empresa = empresa;
        this.proyecto = proyecto;
        this.asesorexterno = asesorExterno;
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
        return asesorexterno;
    }

    public void setAsesorExterno(AsesorExterno asesorExterno) {
        this.asesorexterno = asesorExterno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}
