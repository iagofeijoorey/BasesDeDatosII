/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Evento;

/**
 *
 * @author alumno
 */
public class FachadaGui {
    aplicacion.FachadaAplicacion fa;
    VPrincipal vPrincipal;
    
   public FachadaGui(aplicacion.FachadaAplicacion fa){
        this.fa=fa;
        this.vPrincipal = new VPrincipal(fa);
   }
    
    public void iniciaVista(){
        VAutentificacion vAutentificacion;

        vAutentificacion = new VAutentificacion(vPrincipal, true, fa);
        vPrincipal.setVisible(true);
        vAutentificacion.setVisible(true);
    }

    public void muestraExcepcion(String e) {
        VAviso va;

        va = new VAviso(vPrincipal, true, e);
        va.setVisible(true);
    }

    //Abrir ventanas

    /*
    public void ventanaContactos(VPrincipal vP){
        VContactos vc;

        vc = new VPerfil(vP, fa);
        vc.setVisible(true);
    }

    public void ventanaAcolitos(VPrincipal vP){
        VAcolitos va;

        va = new VPerfil(vP, fa);
        va.setVisible(true);
    }
*/
    public void ventanaPropiedades(){
        VPropiedades vpr;

        vpr = new VPropiedades(fa);
        vpr.setVisible(true);
    }

    public void ventanaDetalles(Propiedad p, int behavior){
        VDetalles_NewProp vdn;

        if (behavior==0)
            vdn = new VDetalles_NewProp(fa, p);
        else
            vdn = new VDetalles_NewProp(fa);

        vdn.setVisible(true);
    }

    public void ventanaContenido(){
        VContenidoAlmacen vdn;

        vdn = new VContenidoAlmacen(fa);
        vdn.setVisible(true);
    }
/*
    public void ventanaRituales(VPrincipal vP){
        VRituales vr;

        vr = new VPerfil(vP, fa);
        vr.setVisible(true);
    }
    */

   /*

   CÓDIGO BIBLIOTECAAAAAAAAAAAAAAAAA

    public void visualizaLibro(Libro l, java.util.List<String>restoCategorias){
        VLibro vl;
        java.util.List<String> categorias = new java.util.ArrayList<String>();

        for(Categoria c:l.getCategorias()){
            categorias.add(c.getNombre());
        }

        vl=new VLibro(vp, true, fa, l, categorias, restoCategorias);
        vl.setVisible(true);
    }

    public void nuevoLibro(java.util.List<String>  restoCategorias){
        VLibro vl;

        vl=new VLibro(vp, true, fa, restoCategorias);
        vl.setVisible(true);
    }

    public void usuarios(){
        VUsuarios u;

        u = new VUsuarios (vp, true, fa);
        u.setVisible(true);
    }

    public void categorias(){
        VCategorías vC;

        vC = new VCategorías (vp, true, fa);
        vC.setVisible(true);
    }

    public void prestar(Evento evento){
        VPrestar vP;

        vP = new VPrestar(vp, true, fa, evento);
        vP.setVisible(true);
    }

    public void muestraExcepcion(String txtExcepcion){
       VAviso va;

       va = new VAviso(vp, true, txtExcepcion);
       va.setVisible(true);
    }

    */
   
}
