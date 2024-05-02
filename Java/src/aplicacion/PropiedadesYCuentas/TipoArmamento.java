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
public enum TipoArmamento {
    //Administrador,
    Pistola,
    Rifle,
    Explosivo,
    ArmaBlanca,
    Escopeta,
    Normal;


    public static TipoArmamento stringToTipoArmamento(String tu){
        switch (tu){
            case ("Pistola"):
                return Pistola;
            case ("Explosivo"):
                return Explosivo;
            case ("Arma blanca"):
                return ArmaBlanca;
            case ("Rifle de asalto"):
                return Rifle;
            case ("Escopeta"):
                return Escopeta;
            default:
                return Normal;
        }
    }

    public static ArrayList<String> valuesString(){
        ArrayList<String> res = new ArrayList<>();

        for (TipoArmamento ta: TipoArmamento.values()){
            res.add(ta.toString());
        }
        return res;
    }
}
