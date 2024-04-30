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




    //public java.util.List<Evento> obtenerEventos(String ubicacion, String fecha) {
    //    return fbd.obtenerEventos(ubicacion, fecha);
    //}

   // public void borrarEvento(Acolito acolito){
   //     fbd.borrarAcolito(acolito);
   // }

   // public void nuevoEvento(Acolito acolito){
   //     fbd.insertarAcolito(acolito);
   // }


    //Código VPrincipal
    public java.util.List<Evento> consultarEventos(String ubicacion, String fecha) {
        return fbd.consultarEventos(ubicacion, fecha);
    }

}
