package aplicacion.PropiedadesYCuentas;

import aplicacion.Acolito;

public class Vehiculo extends Propiedad{
    private TipoVehiculo tipo;
    private int capacidad = 0;
    private Inmobiliario almacen; //Donde está estacionado

    /**
     * Constructor para propiedades inmobiliarias de tipo almacen, indicando la capacidad
     * @param idPropiedad
     * @param ubicacion
     * @param capacidad
     * @param valorActual
     * @param gestor
     */

    /**
     * @param idPropiedad
     * @param ubicacion
     * @param tipo
     * @param valorActual
     * @param gestor
     */
    public Vehiculo(Integer idPropiedad, String ubicacion, TipoVehiculo tipo, int valorActual, Acolito gestor, Inmobiliario almacen){
        super(idPropiedad, valorActual , gestor);
        this.tipo = tipo;
        this.almacen = almacen;
    }


    public TipoVehiculo getTipo() {
        return tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Inmobiliario getAlmacen() {
        return almacen;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setAlmacen(Inmobiliario almacen) {
        this.almacen = almacen;
    }
}
