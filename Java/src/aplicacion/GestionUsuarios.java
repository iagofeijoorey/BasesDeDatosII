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
public class GestionUsuarios {
     
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
   
    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }  
    
    
  public Boolean comprobarAutentificacion(String idUsuario, String clave, FachadaAplicacion faABD){
      Acolito u;

      u=fbd.validarUsuario(idUsuario, clave);
      if (u!=null){
          faABD.setCurrentUser(u);
          return true;
      } else return false;
  }
  
     public java.util.List<Acolito> obtenerUsuarios(){
        return fbd.consultarUsuarios();
    }
     public java.util.List<Acolito> obtenerUsuariosPrestamos(){
        return fbd.consultarUsuariosPrestamos();
    }
     
     public java.util.List<Acolito> buscarUsuariosPrestamos(String IDUsuario, String Nombre) {
         return fbd.consultarUsuariosPrestamos(IDUsuario,Nombre);
     }
     public java.util.List<Acolito> buscarUsuarios(String IDUsuario, String Nombre) {
         return fbd.consultarUsuarios(IDUsuario,Nombre);
     }

     public void borrarUsuario(Acolito acolito){
         fbd.borrarUsuario(acolito);
     }
     
     public void nuevoUsuario(Acolito acolito){
         fbd.insertarUsuario(acolito);
     }
  
}
