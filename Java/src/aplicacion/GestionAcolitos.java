/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;
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

      u=fbd.validarLogin(idUsuario, clave);
      if (u!=null){
          faABD.setCurrentUser(u);
          return true;
      } else return false;
  }
  
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
  
}
