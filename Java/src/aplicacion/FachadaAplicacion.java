/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacion;


/**
 *
 * @author Mateo Bodenlle
 */
public class FachadaAplicacion {
    gui.FachadaGui fgui;
    baseDatos.FachadaBaseDatos fbd;
    GestionAcolitos gAcolitos;
    GestionContactos gContactos;
    GestionEventos gEventos;
    Acolito currentUser;
    
    
    public FachadaAplicacion(){
        fgui=new gui.FachadaGui(this);
        fbd= new baseDatos.FachadaBaseDatos(this);
        gAcolitos = new GestionAcolitos(fgui, fbd);
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
    return gAcolitos.consultarAcolitos();
}


    public java.util.List<Acolito> consultarAcolitos(String IDUsuario, String Nombre){
        return gAcolitos.buscarUsuarios(IDUsuario, Nombre);
    }

    public void nuevoUsuario(Acolito usuario){
    gAcolitos.nuevoUsuario(usuario);
}


    public void borrarAcolito(Acolito usuario){
    gAcolitos.borrarAcolito(usuario);
}


    public Boolean comprobarAutentificacion(String idUsuario, String clave){
        //return cu.comprobarAutentificacion(idUsuario, clave);
        return true;
    }


    public void setCurrentUser(Acolito u) {
        currentUser = u;
    }


    public java.util.List<Evento> obtenerEventos(String ubicacion, String fecha){
        return gEventos.obtenerEventos(ubicacion, fecha);
    }


}
