package com.example.resitecapp.objects;

public class Alumno {
    private String nombre;
    private int numerodecontrol;
    private String ape_pat;
    private String ape_mat;
    private String fecha_nacimiento;
    private String domicilio_calle;
    private String domicilio_colonia;
    private int domicilio_cp;
    private String ciudad;
    private String pais;
    private int nss;
    private String tipo_seguro;
    private String sexo;
    private String correo_personal;
    private String telefono_personal;
    private String telefono_casa;
    private String correo_institucional;
    private int carrera_id;

    public int getCarrera_id() {
        return carrera_id;
    }

    public void setCarrera_id(int carrera_id) {
        this.carrera_id = carrera_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumerodecontrol() {
        return numerodecontrol;
    }

    public void setNumerodecontrol(int numerodecontrol) {
        this.numerodecontrol = numerodecontrol;
    }

    public String getApePat() {
        return ape_pat;
    }

    public void setApePat(String apePat) {
        this.ape_pat = apePat;
    }

    public String getApeMat() {
        return ape_mat;
    }

    public void setApeMat(String apeMat) {
        this.ape_mat = apeMat;
    }

    public String getFechaNacimiento() {
        return fecha_nacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fecha_nacimiento = fechaNacimiento;
    }

    public String getDomicilioCalle() {
        return domicilio_calle;
    }

    public void setDomicilioCalle(String domicilioCalle) {
        this.domicilio_calle = domicilioCalle;
    }

    public String getDomicilioColonia() {
        return domicilio_colonia;
    }

    public void setDomicilioColonia(String domicilioColonia) {
        this.domicilio_colonia = domicilioColonia;
    }

    public int getDomicilioCp() {
        return domicilio_cp;
    }

    public void setDomicilioCp(int domicilioCp) {
        this.domicilio_cp = domicilioCp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNss() {
        return nss;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    public String getTipoSeguro() {
        return tipo_seguro;
    }

    public void setTipoSeguro(String tipoSeguro) {
        this.tipo_seguro = tipoSeguro;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreoPersonal() {
        return correo_personal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correo_personal = correoPersonal;
    }

    public String getTelefonoPersonal() {
        return telefono_personal;
    }

    public void setTelefonoPersonal(String telefonoPersonal) {
        this.telefono_personal = telefonoPersonal;
    }

    public String getTelefonoCasa() {
        return telefono_casa;
    }

    public void setTelefonoCasa(String telefonoCasa) {
        this.telefono_casa = telefonoCasa;
    }

    public String getCorreoInstitucional() {
        return correo_institucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correo_institucional = correoInstitucional;
    }
}
