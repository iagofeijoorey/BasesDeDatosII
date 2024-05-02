package gui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author basesdatos
 */
public enum TipoAcolito {
    //Administrador,
    Cabecilla,
    JefeDivision,
    Gestor,
    LiderEspiritual,
    Normal;


    public static TipoAcolito stringToTipoAcolito(String tu){
        switch (tu){
            case ("Cabecilla"):
                return Cabecilla;
            default:
                return Normal;
        }
    }
}
