/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

/**
 *
 * @author basesdatos
 */
public class GestionContactos {

    FachadaGui fgui;
    FachadaBaseDatos fbd;


    public GestionContactos(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }

/*
    public java.util.List<Contacto>  consultarContactos(String pseudonimo, String nombre){
        return fbd.consultarContacto(pseudonimo,nombre);
    }

    /**
     * Consultar contacto dado el acólito del que es contacto

    public java.util.List<Contacto>  consultarContactosDeAcolito(Acolito acolito, String pseudonimo, String nombre){
        return fbd.consultarContactosDeAcolito(acolito, pseudonimo, nombre);
    }

    /**
     * Consultar contacto dado el nombre o alias aproximado (usamos %) del acólito del que es contacto

    public java.util.List<Contacto>  consultarContactosDeAcolito(String aliasAcolito, String pseudonimoContacto, String nombreContacto){
        return fbd.consultarContactosDeAcolito(aliasAcolito, pseudonimoContacto, nombreContacto);
    }
*/
}
