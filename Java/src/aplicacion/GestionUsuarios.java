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
    
    
  public Boolean comprobarAutentificacion(String idUsuario, String clave){
      Usuario u;

      u=fbd.validarUsuario(idUsuario, clave);
      if (u!=null){
          return u.getTipoUsuario()==TipoUsuario.Administrador;
      } else return false;
  }
  
     public java.util.List<Usuario> obtenerUsuarios(){
        return fbd.consultarUsuarios();
    }
     public java.util.List<Usuario> obtenerUsuariosPrestamos(){
        return fbd.consultarUsuariosPrestamos();
    }
     
     public java.util.List<Usuario> buscarUsuariosPrestamos(String IDUsuario, String Nombre) {
         return fbd.consultarUsuariosPrestamos(IDUsuario,Nombre);
     }
     public java.util.List<Usuario> buscarUsuarios(String IDUsuario, String Nombre) {
         return fbd.consultarUsuarios(IDUsuario,Nombre);
     }

     public void borrarUsuario(Usuario usuario){
         fbd.borrarUsuario(usuario);
     }
     
     public void nuevoUsuario(Usuario usuario){
         fbd.insertarUsuario(usuario);
     }
  
}
