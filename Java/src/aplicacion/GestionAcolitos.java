/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

import java.util.ArrayList;

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
    
    
  public Boolean comprobarAutentificacion(String idUsuario, String clave, FachadaAplicacion faABD){

      Acolito u;

      u = fbd.validarLogin(idUsuario, clave);
      if (u!=null){
          faABD.setCurrentUser(u);
          return true;
      } else return false;
  }

    /////////////// MÉTODOS SARA. VACOLITOS ///////////////
    public ArrayList<String> obtenerAliasAcolitos() {
        return fbd.obtenerAliasAcolitos();
    }

    public Acolito obtenerAcolito(String alias) {
        return fbd.obtenerAcolito(alias);
    }

    public void nuevoAcolito(Acolito acolito){
        fbd.nuevoAcolito(acolito);
    }

    public void actualizarAcolito(Acolito acolito){
        fbd.actualizarAcolito(acolito);
    }

    public void eliminarAcolito(String alias){
         fbd.eliminarAcolito(alias);
     }

}
