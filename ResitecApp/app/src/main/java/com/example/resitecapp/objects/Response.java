package com.example.resitecapp.objects;

public class Response <T> {
    private T objecto;
    private String mensaje;

    public T getObjecto() {
        return objecto;
    }

    public void setObjecto(T objecto) {
        this.objecto = objecto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
