package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author basesdatos
 */
public class Acolito {
    private String alias;
    private String contraseña;
    private Date fechaingreso;
    private String nombreCompleto;
    private double dinero;
    private Integer telefono;
    private String direccion;
    private int influencia;
    private TipoAcolito tipo;
    private boolean primeraEntrada;
    private String nombreDivision; // Atributo por si el acólito es un jefe de división/gestor/guía
    private String jefeDivision; // Atributo por si el acólito es un miembro base y está asociado a una división

    /* Constructor para cuando queremos EXTRAER toda la info de un acólito */
    public Acolito(String alias, String contraseña, Date fechaingreso, String nombreCompleto, double dinero, Integer telefono, String direccion, int influencia, TipoAcolito tipo, boolean primeraEntrada, String jefeDivision, String nombreDivision) {
        this.alias = alias;
        this.contraseña = contraseña;
        this.fechaingreso = fechaingreso;
        this.nombreCompleto = nombreCompleto;
        this.dinero = dinero;
        this.telefono = telefono;
        this.direccion = direccion;
        this.influencia = influencia;
        this.tipo = tipo;
        this.primeraEntrada = primeraEntrada;
        this.nombreDivision = nombreDivision;
        this.jefeDivision = jefeDivision;
    }

    /* Constructor para cuando queremos CREAR un nuevo acólito */
    public Acolito(String alias, String contraseña, String nombreCompleto, Integer telefono, String direccion, int influencia, TipoAcolito tipo, String jefeDivision, String nombreDivision) {
        this.alias = alias;
        this.contraseña = contraseña;
        this.nombreCompleto = nombreCompleto;
        this.dinero = 0;
        this.telefono = telefono;
        this.direccion = direccion;
        this.influencia = influencia;
        this.tipo = tipo;
        this.primeraEntrada = true;
        this.nombreDivision = nombreDivision;
        this.jefeDivision = jefeDivision;
        this.fechaingreso = new Date();
    }

    public String getAlias() {
        return alias;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getInfluencia() {
        return influencia;
    }


    public TipoAcolito getTipo() {
        return tipo;
    }

    public double getDinero() {
        return dinero;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public String getNombreDivision() {
        return nombreDivision;
    }

    public String getJefeDivision() {
        return jefeDivision;
    }

    //Setters

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setInfluencia(int influencia) {
        this.influencia = influencia;
    }

    public void setTipo(TipoAcolito tipo) {
        this.tipo = tipo;
    }

    public void setPrimeraEntrada(boolean primeraEntrada) {
        this.primeraEntrada = primeraEntrada;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public void setFechaingreso(Date fechaingreso){
       this.fechaingreso = fechaingreso;
    }

    public void setNombreDivision(String nombreDivision) {
        this.nombreDivision = nombreDivision;
    }

    public void setJefeDivision(String jefeDivision) {
        this.jefeDivision = jefeDivision;
    }

    //OTRAS FUNCIONES

    public boolean isPrimeraEntrada() {
        return primeraEntrada;
    }
}
