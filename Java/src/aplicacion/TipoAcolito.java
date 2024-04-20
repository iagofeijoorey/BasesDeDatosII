package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author basesdatos
 */
public enum TipoAcolito {
    Administrador,
    Cabecilla,
    JefeDivision,
    Gestor,

    Normal;


    public static TipoAcolito stringToTipoAcolito(String tu){
        switch (tu){
            case ("Administrador"):
                return Administrador;
            default:
                return Normal;
        }
    }
}
