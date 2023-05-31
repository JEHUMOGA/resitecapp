package com.example.resitecapp.objects;

public class Proyecto {
    private int id;
    private int empresa_id;
    private String acronimo;
    private String titulo;
    private String tipo;
    private String realizacion;

    public int getIdProyecto() {
        return id;
    }

    public void setIdProyecto(int idProyecto) {
        this.id = idProyecto;
    }

    public int getEmpresaID() {
        return empresa_id;
    }

    public void setEmpresaID(int empresaID) {
        this.empresa_id = empresaID;
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
