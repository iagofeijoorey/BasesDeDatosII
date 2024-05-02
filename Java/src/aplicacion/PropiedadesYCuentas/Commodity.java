package aplicacion.PropiedadesYCuentas;

import aplicacion.Acolito;
import aplicacion.Evento;

public class Commodity extends Propiedad{
    private String nombre;
    private Integer cantidad;

    public Commodity(Integer idPropiedad, String nombre, Integer cantidad, Integer valorActual, Acolito gestor, java.util.List<Evento> eventos){
        super(idPropiedad, valorActual, gestor, eventos);
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public String getTipoGeneral(){
        return "Commodity";
    };
    public String getTipoString(){
        return nombre;
    };

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }


}
