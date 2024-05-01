package aplicacion.PropiedadesYCuentas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author basesdatos
 */
public enum TipoVehiculo {
    //Administrador,
    Coche,
    Camion,
    Tanque,

    Normal;


    public static TipoVehiculo stringToTipoVehiculo(String tu){
        switch (tu){
            case ("Coche"):
                return Coche;
            default:
                return Normal;
        }
    }
}
