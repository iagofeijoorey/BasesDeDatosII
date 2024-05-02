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
    Casa,
    Piso_Franco;

    public static TipoInmobiliario stringToTipoInmobiliario(String tu){
        switch (tu){
            case ("Almacén"):
                return Almacen;
            case ("Casa"):
                return Casa;
            case ("Piso Franco"):
                return Piso_Franco;
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
