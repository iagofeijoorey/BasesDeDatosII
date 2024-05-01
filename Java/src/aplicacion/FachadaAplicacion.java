/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;


import gui.VContactos;
import gui.VPrincipal;

import javax.xml.transform.Result;
import java.util.ArrayList;

/**
 *
 * @author basesdatos
 */

public class FachadaAplicacion {
    private gui.FachadaGui fgui;
    private baseDatos.FachadaBaseDatos fbd;
    private GestionContactos gc;
    private GestionAcolitos ga;
    
    
    public FachadaAplicacion(){
        fgui=new gui.FachadaGui(this);
        fbd= new baseDatos.FachadaBaseDatos(this);
        gc = new GestionContactos(fgui, fbd);
        ga = new GestionAcolitos(fgui, fbd);
    }


    public static void main(String args[]) {
        FachadaAplicacion fa;
     
        fa= new FachadaAplicacion();
        fa.iniciaInterfazUsuario();
    }
 
    public void iniciaInterfazUsuario(){
     fgui.iniciaVista();
 }

    public void muestraExcepcion(String e){
     fgui.muestraExcepcion(e);
 }

public java.util.List<Acolito> consultarAcolitos(){
    return ga.consultarAcolitos();
}


    public java.util.List<Acolito> consultarAcolitos(String IDUsuario, String Nombre){
        return ga.buscarUsuarios(IDUsuario, Nombre);
    }

    public void nuevoUsuario(Acolito usuario){
    ga.nuevoUsuario(usuario);
}


    public void borrarAcolito(Acolito usuario){
    ga.borrarAcolito(usuario);
}


    public Boolean comprobarAutentificacion(String idUsuario, String clave){
        //return cu.comprobarAutentificacion(idUsuario, clave);
        return true;
    }

    //Abrir ventanas

    public void ventanaContactos(VPrincipal vP){
        fgui.ventanaContactos(vP);
    }

    public void ventanaContactoNuevo(VContactos vc){
        fgui.ventanaContactoNuevo(vc);
    }

    public void ventanaAcolitos(){
        //fgui.ventanaAcolitos();
    }


    public void ventanaRituales(){
        //fgui.ventanaRituales();
    }

    public void actualizarAcolito(String alias, String nombre, String ciudad, String pais){
        ga.actualizarAcolito(alias, nombre, ciudad, pais);
    }

    //Métodos que hacen falta para VContactos
    public ArrayList<Contacto> obtenerContactos(Acolito acolito){
        return gc.obtenerContactos(acolito);
    }

    public void rellenarDatos(VContactos vc){
        gc.rellenarDatos(vc);
    }

    public void actualizarContacto(String pseudonimo, String nombre, String telefono, String descripcion){
        gc.actualizarContacto(pseudonimo, nombre, telefono, descripcion);
    }

    public void eliminarContacto(String pseudonimo){
        gc.eliminarContacto(pseudonimo);
    }

    public ArrayList<Trato> obtenerTratos(String acolito, String contacto){
        return gc.obtenerTratos(acolito, contacto);
    }

    public boolean hayTratos(String acolito, String contacto){
        return gc.hayTratos(acolito, contacto);
    }

    public void proponerTrato(String acolito, String contacto, VContactos vc){
        ArrayList<String> datosTrato = fgui.ventanaTratoNuevo(vc);
        if(datosTrato.get(0) != null)
            gc.proponerTrato(datosTrato, acolito, contacto);
    }

    public boolean existeTrato(Integer id){
        return gc.existeTrato(id);
    }

    public void romperTrato(Trato trato){
        gc.romperTrato(trato);
    }
}

