package com.example.resitecapp.objects;

public class Empresa {
    private  int id;
    private String lugar;
    private String rfc;
    private String giro;
    private String domicilio;
    private String colonia;
    private String cp;
    private String ciudad;
    private String fax;
    private String telefono;
    private String telefono_extension;
    private String nombre_titular;
    private String puesto_titular;

    public int getIdEmpresa() {
        return id;
    }
    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return cp;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.cp = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoExtension() {
        return telefono_extension;
    }

    public void setTelefonoExtension(String telefonoExtension) {
        this.telefono_extension = telefonoExtension;
    }

    public String getNombreTitular() {
        return nombre_titular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombre_titular = nombreTitular;
    }

    public String getPuestoTitular() {
        return puesto_titular;
    }

    public void setPuestoTitular(String puestoTitular) {
        this.puesto_titular = puestoTitular;
    }
}
