package aplicacion.PropiedadesYCuentas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author basesdatos
 */
public enum TipoInmobiliario {
    //Administrador,
    Almacen,
    Normal,
    Casa;


    public static TipoInmobiliario stringToTipoInmobiliario(String tu){
        switch (tu){
            case ("Almacen"):
                return Almacen;
            default:
                return Normal;
        }
    }
}
