package aplicacion.PropiedadesYCuentas;

import aplicacion.Evento;

public class Arma extends Propiedad{
    private TipoArmamento tipo;
    private Integer cantidad;
    private Integer balas;
    private Inmobiliario almacen;

    public Arma(Integer idPropiedad, TipoArmamento tipo, Integer cantidad, Integer balas, Integer valorActual, Inmobiliario almacen, java.util.List<Evento> eventos){
        super(idPropiedad, valorActual, almacen.getGestor(), eventos);
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.balas = balas;
        this.almacen = almacen;
    }

    public Arma(Integer idPropiedad, TipoArmamento tipo, Integer cantidad, Integer balas, Integer valorActual){
        super(idPropiedad, valorActual, null, null);
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.balas = balas;
    }

    // Getters
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
    public String getTipoString(){
        return tipo.toString();
    };
    public String getTipoGeneral(){
        return "arma";
    };

    // Setters
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
