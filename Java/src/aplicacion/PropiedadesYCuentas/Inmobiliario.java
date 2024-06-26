package aplicacion.PropiedadesYCuentas;

import aplicacion.Acolito;
import aplicacion.Evento;

public class Inmobiliario extends Propiedad{
    private String ubicacion;
    private TipoInmobiliario tipo;
    private Integer capacidad = 0;

    /**
     * Constructor para propiedades inmobiliarias de tipo almacen, indicando la capacidad
     * @param idPropiedad
     * @param ubicacion
     * @param capacidad
     * @param valorActual
     * @param gestor
     */
    public Inmobiliario(Integer idPropiedad, String ubicacion, Integer capacidad, TipoInmobiliario tipo, int valorActual, Acolito gestor, java.util.List<Evento> eventos){
        super(idPropiedad, valorActual , gestor, eventos);
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.capacidad = capacidad;
    }

    /**
     * Constructor para propiedades inmobiliaras genéricas (no almacén)
     * @param idPropiedad
     * @param ubicacion
     * @param tipo
     * @param valorActual
     * @param gestor
     */
    public Inmobiliario(Integer idPropiedad, String ubicacion, TipoInmobiliario tipo, Integer valorActual, Acolito gestor, java.util.List<Evento> eventos){
        super(idPropiedad, valorActual , gestor, eventos);
        this.ubicacion = ubicacion;
        this.tipo = tipo;
    }

    // Getters
    public String getUbicacion() {
        return ubicacion;
    }
    public TipoInmobiliario getTipo() {
        return tipo;
    }
    public Integer getCapacidad() {
        return capacidad;
    }
    public String getTipoString(){
        return tipo.toString();
    };
    public String getTipoGeneral(){
        return "Inmobiliario";
    };


    // Setters
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public void setTipo(TipoInmobiliario tipo) {
        this.tipo = tipo;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }


}
