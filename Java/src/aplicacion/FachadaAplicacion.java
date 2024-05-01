/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;


import gui.VPrincipal;
import gui.VContactos;
import java.util.ArrayList;

/*
 * @author basesdatos
 */

public class FachadaAplicacion {
    private gui.FachadaGui fgui;
    private baseDatos.FachadaBaseDatos fbd;
    private GestionEventos ge;
    private GestionContactos gc;
    private GestionAcolitos ga;
    private Acolito currentUser;
    
    
    public FachadaAplicacion(){
        fgui=new gui.FachadaGui(this);
        fbd= new baseDatos.FachadaBaseDatos(this);
        ge = new GestionEventos(fgui, fbd);
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

    public Boolean comprobarAutentificacion(String idUsuario, String clave){
        ga.comprobarAutentificacion(idUsuario, clave, this);
        return true;
    }

    public Acolito getCurrentUser() { return currentUser; }

    public void setCurrentUser(Acolito u) {
        currentUser = u;
    }

    public void ventanaRituales(VPrincipal vP){
        //fgui.ventanaRituales();
    }

    //////////////// MÉTODOS SARA. VACOLITOS ////////////////

    public void ventanaAcolitos(VPrincipal vP){
        fgui.ventanaAcolitos(vP);
    }

    public ArrayList<String> obtenerAliasAcolitos() {
        return ga.obtenerAliasAcolitos();
    }

    public Acolito obtenerAcolito(String alias) {
        return ga.obtenerAcolito(alias);
    }

    public void nuevoAcolito(Acolito acolito){
        ga.nuevoAcolito(acolito);
    }

    public void actualizarAcolito(Acolito a){
        ga.actualizarAcolito(a);
    }

    public void eliminarAcolito(String alias){
        ga.eliminarAcolito(alias);
    }

    public java.util.List<Evento> consultarEventos(String alias){
        return ge.consultarEventos(alias);
    }

    public java.util.List<Evento> consultarEventos(){
        return ge.consultarEventos();
    }

    //////////////// MÉTODOS LAURA. VCONTACTOS ////////////////

    public void ventanaContactos(VPrincipal vP){
        fgui.ventanaContactos(vP);
    }

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
        if(datosTrato.get(1) != null)
            gc.proponerTrato(datosTrato, acolito, contacto);
    }

    public boolean existeTrato(Integer id){
        return gc.existeTrato(id);
    }

    public void romperTrato(Trato trato){
        gc.romperTrato(trato);
    }

    public void crearContacto(String acolito, VContactos vc){
        Contacto contacto = fgui.ventanaContactoNuevo(vc);
        if(contacto != null)
            gc.crearContacto(acolito, contacto.getPseudonimo());
    }

    public Contacto crearContacto(String pseudonimo, String nombre, String telefono, String descripcion){
        return gc.crearContacto(pseudonimo, nombre, telefono, descripcion);
    }

}

