package com.example.resitecapp.objects;

public class Empresa {
    private  String idEmpresa;
    private String lugar;
    private String rfc;
    private String giro;
    private String domicilio;
    private String Colonia;
    private String codigoPostal;
    private String ciudad;
    private String fax;
    private String telefono;
    private String telefonoExtension;
    private String nombretitular;
    private String puestotitular;

    public String getIdEmpresa() {
        return idEmpresa;
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
        return Colonia;
    }

    public void setColonia(String colonia) {
        Colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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
        return telefonoExtension;
    }

    public void setTelefonoExtension(String telefonoExtension) {
        this.telefonoExtension = telefonoExtension;
    }

    public String getNombreTitular() {
        return nombretitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombretitular = nombreTitular;
    }

    public String getPuestoTitular() {
        return puestotitular;
    }

    public void setPuestoTitular(String puestoTitular) {
        this.puestotitular = puestoTitular;
    }
}
