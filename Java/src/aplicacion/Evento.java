/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author basesdatos
 */
public class Evento {

    private String ubicacion;
    private String fecha;
    private TipoEvento tipoEvento;
    private String descripcion;
    private Acolito autorizador;
    private Acolito organizador;
    private List<Recompensa> recompensa = new ArrayList<>(); //Sin inicializar, se cargan las recompensas con el método setRecompensa,
    //y la consulta correspondiente definida en el DAOEvento cuando se necesite

    //Constructor
    public Evento(String ubicacion, String fecha, TipoEvento tipoEvento, String descripcion, Acolito organizador) {
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
    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }
    public String getDescripcion(){ return descripcion; }
    public Acolito getAutorizador() {
        return autorizador;
    }
    public Acolito getOrganizador() {
        return organizador;
    }
    public List<Recompensa> getRecompensa() {
        return recompensa;
    }

    //Setters
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setTipoEvento(TipoEvento tipoEvento) {
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
    public void setRecompensa(List<Recompensa> recompensa) {
        this.recompensa = recompensa;
    }

    //OTRAS FUNCIONES
}
