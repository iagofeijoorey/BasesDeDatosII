/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Acolito;
import aplicacion.Libro;
import aplicacion.Ejemplar;

/**
 *
 * @author alumno
 */
public class FachadaGui {
    aplicacion.FachadaAplicacion fa;
    VPrincipal vp;
    
   public FachadaGui(aplicacion.FachadaAplicacion fa){
     this.fa=fa;
     this.vp = new VPrincipal(fa);
   } 
    
    
    
    public void iniciaVista(){
      VAutentificacion va;
    
      va = new VAutentificacion(vp, true, fa);
      vp.setVisible(true);
      va.setVisible(true);
    }
    
   
    public void visualizaLibro(Libro l, java.util.List<String>restoCategorias){
        vAcolitos vl;
        java.util.List<String> categorias = new java.util.ArrayList<String>();
        
        for(Acolito c:l.getCategorias()){
            categorias.add(c.getNombre());
        }
        
        vl=new vAcolitos(vp, true, fa, l, categorias, restoCategorias);
        vl.setVisible(true);
    }
    
    public void nuevoLibro(java.util.List<String>  restoCategorias){
        vAcolitos vl;
        
        vl=new vAcolitos(vp, true, fa, restoCategorias);
        vl.setVisible(true);
    }
    
    public void usuarios(){
        VUsuarios u;
        
        u = new VUsuarios (vp, true, fa);
        u.setVisible(true);
    }
    
    public void categorias(){
        vContrato vC;
        
        vC = new vContrato(vp, true, fa);
        vC.setVisible(true);
    }
    
    public void prestar(Ejemplar ejemplar){
        VPrestar vP;
        
        vP = new VPrestar(vp, true, fa, ejemplar);
        vP.setVisible(true);
    }
    
    public void muestraExcepcion(String txtExcepcion){
       VAviso va;
       
       va = new VAviso(vp, true, txtExcepcion);
       va.setVisible(true);
    }

    
   
}
