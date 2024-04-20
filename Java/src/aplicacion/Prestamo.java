package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;

/**
 *
 * @author basesdatos
 */
public class Prestamo {

    private Libro libro;
    private Ejemplar ejemplar;
    private Acolito acolito;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public Prestamo (Libro libro, Ejemplar ejemplar, Acolito acolito, Date fechaPrestamo){
        this.libro = libro;
        this.ejemplar = ejemplar;
        this.acolito = acolito;
        this.fechaPrestamo = fechaPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public Acolito getUsuario() {
        return acolito;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public void setUsuario(Acolito acolito) {
        this.acolito = acolito;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void devolver (Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    
}
