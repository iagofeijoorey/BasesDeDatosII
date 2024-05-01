/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;
import aplicacion.PropiedadesYCuentas.Inmobiliario;
import aplicacion.PropiedadesYCuentas.Propiedad;
import gui.VPrincipal;

import java.util.ArrayList;

/**
 *
 * @author basesdatos
 */

public class FachadaAplicacion {
    private gui.FachadaGui fgui;
    private baseDatos.FachadaBaseDatos fbd;
    private GestionEventos ge;
    private GestionPropiedades gp;
    private GestionContactos gc;
    private GestionAcolitos ga;
    private Acolito currentUser;

    public static void main(String[] args) {
        FachadaAplicacion fa;

        fa= new FachadaAplicacion();

        fa.iniciaInterfazUsuario();
    }

    public FachadaAplicacion(){
        fgui=new gui.FachadaGui(this);
        fbd= new baseDatos.FachadaBaseDatos(this);
        ge = new GestionEventos(fgui, fbd);
        gp = new GestionPropiedades(fgui, fbd);
        gc = new GestionContactos(fgui, fbd);
        ga = new GestionAcolitos(fgui, fbd);
    }
 
    public void iniciaInterfazUsuario(){
     fgui.iniciaVista();
 }

    public void muestraExcepcion(String e){
     fgui.muestraExcepcion(e);
 }


    ///Código abrir ventanas
    //////////////////////////////////////////
    public void ventanaContactos(){
        //fgui.ventanaContactos();
    }
    public void ventanaAcolitos(){
        //fgui.ventanaAcolitos();
    }
    public void ventanaPropiedades(){
        fgui.ventanaPropiedades();
    }
    public void ventanaDetalles(Propiedad p, int behavior){
        fgui.ventanaDetalles(p, behavior);
    }
    public void ventanaContenido(Inmobiliario almacen){
        fgui.ventanaContenido(almacen);
    }
    public void ventanaEventos(){
        fgui.ventanaEventos();
    }
    public void ventanaRituales(){
        //fgui.ventanaRituales();
    }

    //Métodos de VPerfil
    public void actualizarAcolito(String alias, String nombre, String ciudad, String pais){
        //ga.actualizarAcolito(alias, nombre, ciudad, pais);
    }


    ///Código consultas
    //////////////////////////////////////////
    public java.util.List<Evento> consultarEventos(Evento evento){
        return ge.consultarEventos(evento);
    }

    public java.util.List<Evento> consultarEventosSinArgs(){
        return ge.consultarEventosSinArgs();
    }
    public void borrarEvento(Evento evento){
        ge.borrarEvento(evento);
    }

    public void anhadirEvento(Evento evento){
        ge.anhadirEvento(evento);
    }


    public java.util.List<Propiedad> consultarPropiedades(String tipo){
        return gp.consultarPropiedades(tipo);
    }

    public void borrarPropiedad(String idPropiedad){
        gp.borrarPropiedad(idPropiedad);
    }
}

