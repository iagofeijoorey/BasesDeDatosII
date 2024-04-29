/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

/**
 *
 * @author basesdatos
 */
public class Evento {

    private String ubicacion;
    private String fecha;
    private String tipoEvento;
    private String descripcion;
    private Acolito autorizador;
    private Acolito organizador;

    //Constructor
    public Evento(String ubicacion, String fecha, String tipoEvento, String descripcion, Acolito organizador) {
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.tipoEvento = tipoEvento;
        this.descripcion = descripcion;
        this.autorizador = null;
        this.organizador = organizador;
    }

    //Getters
    public String getUbicacion() {
        return ubicacion;
    }
    public String getFecha() {
        return fecha;
    }
    public String getTipoEvento() {
        return tipoEvento;
    }
    public String getDescripcion(){ return descripcion; }
    public Acolito getAutorizador() {
        return autorizador;
    }
    public Acolito getOrganizador() {
        return organizador;
    }

    //Setters
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setAutorizador(Acolito autorizador) {
        this.autorizador = autorizador;
    }
    public void setOrganizador(Acolito organizador) {
        this.organizador = organizador;
    }

    //OTRAS FUNCIONES
}
