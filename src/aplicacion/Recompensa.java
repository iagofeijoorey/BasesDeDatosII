package aplicacion;

import java.util.ArrayList;

public abstract class Recompensa {
    private int idRecompensa;
    private int idObjetivo;
    private String fecha;
    private String ubicacion;

    public Recompensa(int idRecompensa, int idObjetivo, String fecha, String ubicacion) {
        this.idRecompensa = idRecompensa;
        this.idObjetivo = idObjetivo;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
    }

    public int getIdRecompensa() {
        return idRecompensa;
    }


    public int getIdObjetivo() {
        return idObjetivo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setIdRecompensa(int idRecompensa) {
        this.idRecompensa = idRecompensa;
    }


    public void setIdObjetivo(int idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public abstract void realizarRecompensa(ArrayList<Acolito> acolitos);



}
