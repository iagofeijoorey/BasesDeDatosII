package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author basesdatos
 */
public enum TipoUsuario {
    Administrador,
    Normal;

    public static TipoUsuario stringToTipoUsuario(String tu){
        switch (tu){
            case ("Administrador"):
                return Administrador;
            default:
                return Normal;
        }
    }
}
