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
}





