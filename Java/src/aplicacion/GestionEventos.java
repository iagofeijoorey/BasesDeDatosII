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


    public java.util.List<Evento> consultarEventos(){
        return fbd.consultarEventos();
    }

    public java.util.List<Evento> consultarEventos(String alias) {
        return fbd.consultarEventos(alias);
    }

    /*public void borrarEvento(Acolito acolito){
        fbd.borrarAcolito(acolito);
    }

    public void nuevoEvento(Acolito acolito){
        fbd.insertarAcolito(acolito);
    }*/

}
