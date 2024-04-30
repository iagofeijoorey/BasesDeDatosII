package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author basesdatos
 */
public enum TipoEvento {
    //Administrador,
    Yoquese,
    JefeDivision,
    Gestor,
    LiderEspiritual,
    Normal;


    public static TipoEvento stringToTipoEvento(String tu){
        switch (tu){
            case ("Cabecilla"):
                return Yoquese;
            default:
                return Normal;
        }
    }
}
