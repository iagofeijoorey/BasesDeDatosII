package aplicacion.PropiedadesYCuentas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


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
}
