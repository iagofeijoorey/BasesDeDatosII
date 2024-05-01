/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;
import aplicacion.PropiedadesYCuentas.Inmobiliario;
import aplicacion.PropiedadesYCuentas.Propiedad;
import gui.VPrincipal;

import java.util.ArrayList;
import java.util.List;

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
 /*
public java.util.List<Libro> obtenerLibros(Integer id, String titulo, String isbn, String autor){
  return cl.obtenerLibros(id, titulo,  isbn,  autor);
}*/
/*
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


    public void setCurrentUser(Acolito u) {
        currentUser = u;
    }
*/
    //Abrir ventanas
//    public void ventanaPerfil(VPrincipal vp){
//        fgui.ventanaPerfil(vp);
//    }


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

    public void ventanaDetalles(){
        fgui.ventanaDetalles();
    }

    public void ventanaContenido(Inmobiliario almacen){
        fgui.ventanaContenido(almacen);
    }

    public void ventanaEventos(){
        //fgui.ventanaEventos();
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
    /*public java.util.List<Evento> consultarEventos(String ubicacion, String fecha){
        return ge.consultarEventos(ubicacion, fecha);
    }*/

    public java.util.List<Propiedad> consultarPropiedades(String tipo){
        return gp.consultarPropiedades(tipo);
    }

    public void borrarPropiedad(String idPropiedad){
        gp.borrarPropiedad(idPropiedad);
    }

    public List<String> consultarArmasAlmacen(Inmobiliario almacen) {
        return gp.consultarArmasAlmacen(almacen);
    }

    public List<String> consultarVehiculosAlmacen(Inmobiliario almacen) {
        return gp.consultarVehiculosAlmacen(almacen);
    }
}

