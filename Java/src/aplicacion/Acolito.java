package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author basesdatos
 */
public class Acolito {

    // Atributos de los acólitos
    private String alias;
    private String nombreCompleto;
    private String clave;
    private String fechaNacimiento;
    private int telefono;
    private String direccion;
    private int influencia;
    private float dinero;
    private boolean primeraEntrada;

    // Constructor
    public Acolito(String alias, String nombreCompleto, String clave, String fechaNacimiento, int telefono, String direccion, int influencia, float dinero) {
        this.alias = alias;
        this.nombreCompleto = nombreCompleto;
        this.clave = clave;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.influencia = influencia;
        this.dinero = dinero;
        this.primeraEntrada = true;
    }

    // Getters
    public String getAlias() {
        return alias;
    }
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    public String getClave() {
        return clave;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public int getTelefono() {
        return telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public int getInfluencia() {
        return influencia;
    }
    public float getDinero() {
        return dinero;
    }
    public boolean isPrimeraEntrada() {
        return primeraEntrada;
    }

    // Setters
    public void setAlias(String alias) {
        this.alias = alias;
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setInfluencia(int influencia) {
        this.influencia = influencia;
    }
    public void setDinero(float dinero) {
        this.dinero = dinero;
    }
    public void setPrimeraEntrada(boolean primeraEntrada) {
        this.primeraEntrada = primeraEntrada;
    }

}





