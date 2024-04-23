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
    private Evento evento;
    private Usuario usuario;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public Prestamo (Libro libro, Evento evento, Usuario usuario, Date fechaPrestamo){
        this.libro = libro;
        this.evento = evento;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public Evento getEjemplar() {
        return evento;
    }

    public Usuario getUsuario() {
        return usuario;
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

    public void setEjemplar(Evento evento) {
        this.evento = evento;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void devolver (Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    
}
