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
public class GestionCategorias {
     
    FachadaGui fgui;
    FachadaBaseDatos fbd;
    
   
    public GestionCategorias(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }  
    
    
  public Boolean comprobarAutentificacion(String idUsuario, String clave){
      Acolito u;

      u=fbd.validarUsuario(idUsuario, clave);
      if (u!=null){
          return u.getTipoUsuario()== TipoAcolito.Administrador;
      } else return false;
  }
  

  public void nuevaCategoria(Categoria categoria){
      fbd.insertarCategoria(categoria);
  }
  
  public void borrarCategoria(Categoria categoria){
      fbd.borrarCategoria(categoria);
  }
 
  
}
