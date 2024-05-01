package aplicacion.PropiedadesYCuentas;

import aplicacion.Acolito;

public class Inmobiliario extends Propiedad{
    private String ubicacion;
    private TipoInmobiliario tipo;
    private int capacidad = 0;

    /**
     * Constructor para propiedades inmobiliarias de tipo almacen, indicando la capacidad
     * @param idPropiedad
     * @param ubicacion
     * @param capacidad
     * @param valorActual
     * @param gestor
     */
    public Inmobiliario(Integer idPropiedad, String ubicacion, int capacidad, int valorActual, Acolito gestor){
        super(idPropiedad, valorActual , gestor);
        this.ubicacion = ubicacion;
        this.tipo = TipoInmobiliario.Almacen;
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
    public Inmobiliario(Integer idPropiedad, String ubicacion, TipoInmobiliario tipo, int valorActual, Acolito gestor){
        super(idPropiedad, valorActual , gestor);
        this.ubicacion = ubicacion;
        this.tipo = tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public TipoInmobiliario getTipo() {
        return tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

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
