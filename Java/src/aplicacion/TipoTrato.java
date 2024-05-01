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
    DebesFavor,
    DebeFavor,
    Deuda,
    Extorsion;


    public static TipoTrato stringToTipTrato(String tt){
        switch (tt){
            case ("Soborno"):
                return Soborno;
            case ("DebesFavor"):
                return DebesFavor;
            case ("Deuda"):
                return Deuda;
            case ("Extorsion"):
                return Extorsion;
            default:
                return DebeFavor;
        }
    }
}
