package aplicacion;
import aplicacion.PropiedadesYCuentas.Inmobiliario;
import aplicacion.PropiedadesYCuentas.Arma;
import aplicacion.PropiedadesYCuentas.Inmobiliario;
import aplicacion.PropiedadesYCuentas.Propiedad;
import aplicacion.PropiedadesYCuentas.Vehiculo;
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
    public void ventanaDetalles(Propiedad p, int behavior){
        fgui.ventanaDetalles(p, behavior);
    }
    public void ventanaContenido(Inmobiliario almacen){
        fgui.ventanaContenido(almacen);
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

    ///Codigo de gestionEventos
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


    ///Código de GestionPropiedades
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

    public List<Objetivo> consultarObjetivosEvento(Evento evento) {
        return ge.consultarObjetivosEvento(evento);
    }

    public void actualizarObjetivo(Objetivo objetivoSeleccionado) {
        ge.actualizarObjetivo(objetivoSeleccionado);
    }

    public void actualizarRecompensaDinero(RecompensaDinero recompensa) {
        ge.actualizarRecompensaDinero(recompensa);
    }

    public void borrarRecompensaDinero(RecompensaDinero recompensa) {
        ge.borrarRecompensaDinero(recompensa);
    }

    public void actualizarRecompensaInfluencia(RecompensaInfluencia recompensa) {
        ge.actualizarRecompensaInfluencia(recompensa);
    }

    public void borrarRecompensaInfluencia(RecompensaInfluencia recompensa) {
        ge.borrarRecompensaInfluencia(recompensa);
    }

    public void borrarObjetivo(Objetivo objetivoSeleccionado) {
        ge.borrarObjetivo(objetivoSeleccionado);
    }

            // Contenido Almacenes
    public java.util.List<Vehiculo> consultarVehiculos(Integer idAlmacen) {
        return gp.consultarVehiculos(idAlmacen);
    }
    public java.util.List<Arma> consultarArmas(Integer idAlmacen) {
        return gp.consultarArmas(idAlmacen);
    }

            // Anadir propiedad
    public void anadirPropiedad(Propiedad p){
        gp.anadirPropiedad(p);
    }

            // ActualizarPropiedad
    public void actualizarPropiedad(Propiedad p){
        gp.actualizarPropiedad(p);
    }
}

