package aplicacion.PropiedadesYCuentas;

import aplicacion.Acolito;

public class Commodity extends Propiedad{
    private String nombre;
    private Integer cantidad;

    public Commodity(Integer idPropiedad, String nombre, Integer cantidad, Integer valorActual, Acolito gestor){
        super(idPropiedad, valorActual, gestor);
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
