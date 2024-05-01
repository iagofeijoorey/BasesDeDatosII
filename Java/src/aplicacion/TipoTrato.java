package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author basesdatos
 */
public enum TipoTrato {
    //Administrador,
    Soborno,
    Favor,
    Deuda,
    Extorsion,
    Normal;


    public static TipoTrato stringToTipoAcolito(String tu){
        switch (tu){
            case ("Soborno"):
                return Soborno;
            default:
                return Normal;
        }
    }
}
