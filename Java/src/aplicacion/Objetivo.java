package aplicacion;

import aplicacion.Recompensa;

import java.util.ArrayList;

public class Objetivo {
    private int idObjetivo;

    private String ubicacion;
    private String fecha;
    private String descripcion;
    private int prioridad;
    private ArrayList<Recompensa> recompensas;

    public Objetivo(int idObjetivo, String ubicacion, String fecha, String descripcion, int prioridad, ArrayList<Recompensa> recompensa) {
        this.idObjetivo = idObjetivo;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.recompensas = recompensa;
    }


    public int getIdObjetivo() {
        return idObjetivo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public ArrayList<Recompensa> getRecompensa() {
        return recompensas;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public void setRecompensa(ArrayList<Recompensa> recompensa) {
        this.recompensas = recompensa;
    }

    public void addRecompensa(Recompensa recompensa) {
        this.recompensas.add(recompensa);
    }


}
