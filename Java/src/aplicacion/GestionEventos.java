//PACKAGE
package aplicacion;

//IMPORTS
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;


public class GestionEventos {

    FachadaGui fgui;
    FachadaBaseDatos fbd;


    public GestionEventos(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fgui=fgui;
        this.fbd=fbd;
    }




    public void borrarEvento(Evento evento){
        fbd.borrarEvento(evento);
    }

    public void nuevoEvento(Evento evento){
        fbd.insertarEvento(evento);
    }


    //Código VPrincipal
    public java.util.List<Evento> consultarEventos(String ubicacion, String fecha) {
        return fbd.consultarEventos(ubicacion, fecha);
    }

}
