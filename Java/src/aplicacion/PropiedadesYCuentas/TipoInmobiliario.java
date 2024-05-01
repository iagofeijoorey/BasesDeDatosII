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

    public static ArrayList<String> valuesString(){
        ArrayList<String> res = new ArrayList<>();

        for (TipoInmobiliario ta: TipoInmobiliario.values()){
            res.add(ta.toString());
        }
        return res;
    }
}
