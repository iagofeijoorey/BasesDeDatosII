/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.Evento;

import java.util.ArrayList;

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

    public void ventanaContactos(VPrincipal vP){
        VContactos vc;

        vc = new VContactos(vP, fa);
        vc.setVisible(true);
    }

    public void ventanaContactoNuevo(VContactos vc){
        VContactoNuevo vcn;

        vcn = new VContactoNuevo(vc, fa);
        vcn.setVisible(true);
    }

    public ArrayList<String> ventanaTratoNuevo(VContactos vc){
        VTratoNuevo vtn;
        ArrayList<String> datosTrato = new ArrayList<>();

        vtn = new VTratoNuevo(vc, fa);
        vtn.setVisible(true);

        datosTrato.add(vtn.getIdentificador());
        datosTrato.add(vtn.getTipoTrato());

        return datosTrato;
    }


    public void rellenarDatos(VContactos vc){
       vc.rellenarDatos();
    }

    /*
    public void ventanaAcolitos(VPrincipal vP){
        VAcolitos va;

        va = new VPerfil(vP, fa);
        va.setVisible(true);
    }

    public void ventanaPropiedades(VPrincipal vP){
        VPropiedades vpr;

        vpr = new VPerfil(vP, fa);
        vpr.setVisible(true);
    }

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
