package aplicacion.PropiedadesYCuentas;

public class Vehiculo extends Propiedad{
    private TipoVehiculo tipo;
    private Integer cantidad;
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
     * @param tipo
     * @param valorActual
     */
    public Vehiculo(Integer idPropiedad, TipoVehiculo tipo, int valorActual, Integer capacidad, Inmobiliario almacen){
        super(idPropiedad, valorActual, almacen.getGestor());
        this.tipo = tipo;
        this.almacen = almacen;
        this.cantidad = capacidad;
    }

    public Vehiculo(Integer idPropiedad, TipoVehiculo tipo, int valorActual, Integer capacidad){
        super(idPropiedad, valorActual, null);
        this.tipo = tipo;
        this.cantidad = capacidad;
    }

    // Getters
    public TipoVehiculo getTipo() {
        return tipo;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public Inmobiliario getAlmacen() {
        return almacen;
    }
    public String getTipoGeneral(){
        return "Vehículo";
    };
    public String getTipoString(){
        return tipo.toString();
    };

    // Setters
    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setAlmacen(Inmobiliario almacen) {
        this.almacen = almacen;
    }

}
