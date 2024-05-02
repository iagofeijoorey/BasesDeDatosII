package aplicacion.PropiedadesYCuentas;

public class Objetivo {
    private int idObjetivo;

    private String ubicacion;
    private String fecha;
    private String descripcion;
    private int prioridad;

    public Objetivo(int idObjetivo, String ubicacion, String fecha, String descripcion, int prioridad) {
        this.idObjetivo = idObjetivo;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
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
}
