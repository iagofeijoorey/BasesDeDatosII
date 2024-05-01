package aplicacion.PropiedadesYCuentas;

public class Arma extends Propiedad{
    private TipoArmamento tipo;
    private Integer cantidad;
    private Integer balas;
    private Inmobiliario almacen;

    public Arma(Integer idPropiedad, TipoArmamento tipo, Integer cantidad, Integer balas, Integer valorActual, Inmobiliario almacen){
        super(idPropiedad, valorActual, almacen.getGestor());
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.balas = balas;
        this.almacen = almacen;
    }

    public TipoArmamento getTipo() {
        return tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Integer getBalas() {
        return balas;
    }

    public Inmobiliario getAlmacen() {
        return almacen;
    }

    public void setTipo(TipoArmamento tipo) {
        this.tipo = tipo;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setBalas(Integer balas) {
        this.balas = balas;
    }

    public void setAlmacen(Inmobiliario almacen) {
        this.almacen = almacen;
    }
}
