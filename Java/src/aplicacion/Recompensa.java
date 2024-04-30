package aplicacion;

public class Recompensa {
    private int idRecompensa;
    private int cantidad;
    private int idObjetivo;
    private String fecha;
    private String ubicacion;

    public Recompensa(int idRecompensa, int cantidad, int idObjetivo, String fecha, String ubicacion) {
        this.idRecompensa = idRecompensa;
        this.cantidad = cantidad;
        this.idObjetivo = idObjetivo;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
    }

    public int getIdRecompensa() {
        return idRecompensa;
    }

    public int getCantidad() {
        return cantidad;
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

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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



}
