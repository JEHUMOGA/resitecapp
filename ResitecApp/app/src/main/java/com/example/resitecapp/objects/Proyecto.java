package com.example.resitecapp.objects;

public class Proyecto {
    private int empresaID;
    private String acronimo;
    private String titulo;
    private String tipo;
    private String realizacion;

    public int getEmpresaID() {
        return empresaID;
    }

    public void setEmpresaID(int empresaID) {
        this.empresaID = empresaID;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRealizacion() {
        return realizacion;
    }

    public void setRealizacion(String realizacion) {
        this.realizacion = realizacion;
    }
}
