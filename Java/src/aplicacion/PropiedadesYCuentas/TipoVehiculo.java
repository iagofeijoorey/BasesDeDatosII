package aplicacion.PropiedadesYCuentas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

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
            case ("Coche"): case ("Automóvil"):
                return Coche;
            case ("Camión"):
                return Camion;
            case ("Tanque"):
                return Tanque;

            default:
                return Normal;
        }
    }
    public static ArrayList<String> valuesString(){
        ArrayList<String> res = new ArrayList<>();

        for (TipoVehiculo ta: TipoVehiculo.values()){
            res.add(ta.toString());
        }
        return res;
    }
}
