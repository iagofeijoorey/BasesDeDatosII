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

    Normal;


    public static TipoArmamento stringToTipoArmamento(String tu){
        switch (tu){
            case ("Rifle"):
                return Rifle;
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
