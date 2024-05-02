/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

import java.util.SortedMap;

/**
 *
 * @author basesdatos
 */
public class GestionAcolitos {
     
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
   
    public GestionAcolitos(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }

    public void actualizarAcolito(Acolito organizador) {


            fbd.actualizarAcolito(organizador);

    }
    

    public Boolean comprobarAutentificacion(String alias, String clave){
        return fbd.comprobarAutentificacion(alias, clave);
    }

    public Acolito devolverUsuario(String alias, String clave){
        return fbd.devolverUsuario(alias, clave);
    }

    public java.util.List<String> getNombresJefesDeDivision(){
        return fbd.getNombresJefesDeDivision();
    }
/*
     public java.util.List<Acolito> consultarAcolitos(){
        return fbd.consultarAcolitos();
    }

     public java.util.List<Acolito> buscarUsuarios(String IDUsuario, String Nombre) {
         return fbd.consultarAcolitos(IDUsuario,Nombre);
     }

     public void borrarAcolito(Acolito acolito){
         fbd.borrarAcolito(acolito);
     }
     
     public void nuevoUsuario(Acolito acolito){
         fbd.insertarAcolito(acolito);
     }

    public void actualizarAcolito(String alias, String nombre, String ciudad, String pais){
        fbd.actualizarAcolito(alias, nombre, ciudad, pais);
    }
    */
}
