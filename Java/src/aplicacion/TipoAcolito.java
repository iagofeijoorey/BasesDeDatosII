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
    //Administrador,
    Cabecilla,
    JefeDivision,
    Gestor,
    GuiaEspiritual,
    Normal;


    public static TipoAcolito stringToTipoAcolito(String tu){
        return switch (tu) {
            case ("Cabecilla") -> Cabecilla;
            case ("JefeDivision") -> JefeDivision;
            case ("Gestor") -> Gestor;
            case ("GuiaEspiritual") -> GuiaEspiritual;
            default -> Normal;
        };
    }
}
