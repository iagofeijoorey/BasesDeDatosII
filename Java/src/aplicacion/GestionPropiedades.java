/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;

import aplicacion.PropiedadesYCuentas.Propiedad;
import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

/**
 *
 * @author basesdatos
 */
public class GestionPropiedades {

    FachadaGui fgui;
    FachadaBaseDatos fbd;


    public GestionPropiedades(FachadaGui fgui, FachadaBaseDatos fbd){
     this.fgui=fgui;
     this.fbd=fbd;
    }  

  
     //public java.util.List<Propiedad> consultarPropiedades(){
     //    return fbd.consultarPropiedades();
   // }

     //public java.util.List<Acolito> buscarUsuarios(String IDUsuario, String Nombre) {
     //    return fbd.consultarAcolitos(IDUsuario,Nombre);
    // }

     //public void borrarAcolito(Acolito acolito){
    //     fbd.borrarAcolito(acolito);
    // }
     
  //   public void nuevoUsuario(Acolito acolito){
   //      fbd.insertarAcolito(acolito);
     //}
  
}
