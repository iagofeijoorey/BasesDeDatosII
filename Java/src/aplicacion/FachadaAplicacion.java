package aplicacion;
import aplicacion.PropiedadesYCuentas.Inmobiliario;
import aplicacion.PropiedadesYCuentas.Arma;
import aplicacion.PropiedadesYCuentas.Inmobiliario;
import aplicacion.PropiedadesYCuentas.Propiedad;
import aplicacion.PropiedadesYCuentas.Vehiculo;
import gui.VPrincipal;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class FachadaAplicacion {
    private gui.FachadaGui fgui;
    private baseDatos.FachadaBaseDatos fbd;
    private GestionEventos ge;
    private GestionPropiedades gp;
    private GestionContactos gc;
    private GestionAcolitos ga;
    private Acolito currentUser;

    public static void main(String[] args) {
        aplicacion.FachadaAplicacion fa;

        fa= new aplicacion.FachadaAplicacion();
        fa.iniciaInterfazUsuario();
    }

    public FachadaAplicacion(){
        currentUser = null;
        fgui=new gui.FachadaGui(this);
        fbd= new baseDatos.FachadaBaseDatos(this);
        ge = new GestionEventos(fgui, fbd);
        gp = new GestionPropiedades(fgui, fbd);
        gc = new GestionContactos(fgui, fbd);
        ga = new GestionAcolitos(fgui, fbd);
    }

    public Acolito getCurrentUser(){
        return currentUser;
    }

    public void iniciaInterfazUsuario(){
        fgui.iniciaVista();
    }

    public void muestraExcepcion(String e){
        fgui.muestraExcepcion(e);
    }

    ///Código de VAutentificacion
    //////////////////////////////////////////
    public void setUsuario(String alias, String clave){
        currentUser = ga.devolverUsuario(alias, clave);
    }
    public boolean comprobarAutentificacion(String alias, String clave){
        return ga.comprobarAutentificacion(alias, clave);
    }


    ///Código de VEventos
    /////////////////////////////////////////////
    public java.util.List<String> getNombresJefesDeDivision(){
        return ga.getNombresJefesDeDivision();
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
    public void ventanaObjetivo(Window parent, Evento evento) {
        fgui.ventanaObjetivo(parent, evento);
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
    public void borrarPropiedad(Integer idPropiedad){
        gp.borrarPropiedad(idPropiedad);
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

    // Buscar mayor id Propiedad
    public Integer obtenerIdPropiedadMayor(){
        return gp.obtenerIdPropiedadMayor();
    }

    // Contenido Almacén
    public java.util.List<Inmobiliario> consultaAlmacenes(){
        // TODO add your code here
        return gp.consultaAlmacenes();
    }

    // Contenido Almacenes


    // Anadir propiedad


    // ActualizarPropiedad






    ///Código de GestionObjetivos/Recompensas
    public List<Objetivo> consultarObjetivosEvento(Evento evento) {
        return ge.consultarObjetivosEvento(evento);
    }

    public int actualizarObjetivo(Objetivo objetivoSeleccionado) {
        return ge.actualizarObjetivo(objetivoSeleccionado);
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

    public void ventanaObjetivo(Window parent, Evento evento) {
        fgui.ventanaObjetivo(parent, evento);
    }

    public void actualizarAcolito(Acolito organizador) {
        ga.actualizarAcolito(organizador);
    }
}

