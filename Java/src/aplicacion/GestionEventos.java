//PACKAGE
package aplicacion;

//IMPORTS
import gui.FachadaGui;
import baseDatos.FachadaBaseDatos;

import java.util.List;


public class GestionEventos {

    FachadaGui fgui;
    FachadaBaseDatos fbd;


    public GestionEventos(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fgui=fgui;
        this.fbd=fbd;
    }

    public List<Objetivo> consultarObjetivosEvento(Evento evento) {
        return fbd.consultarObjetivosEvento(evento);
    }

    public void actualizarObjetivo(Objetivo objetivoSeleccionado) {
        fbd.actualizarObjetivo(objetivoSeleccionado);
    }

    public void actualizarRecompensaDinero(RecompensaDinero recompensa) {
        if (recompensa.getIdRecompensa() == -1) {
            fbd.insertarRecompensaDinero(recompensa);
        } else {
            fbd.actualizarRecompensaDinero(recompensa);
        }
    }

    public void borrarRecompensaDinero(RecompensaDinero recompensa) {
        fbd.borrarRecompensaDinero(recompensa);
    }

    public void actualizarRecompensaInfluencia(RecompensaInfluencia recompensa) {
        if (recompensa.getIdRecompensa() == -1) {
            fbd.insertarRecompensaInfluencia(recompensa);
        } else {
            fbd.actualizarRecompensaInfluencia(recompensa);
        }
    }

    public void borrarRecompensaInfluencia(RecompensaInfluencia recompensa) {
        fbd.borrarRecompensaInfluencia(recompensa);
    }

    public void borrarObjetivo(Objetivo objetivoSeleccionado) {
        fbd.borrarObjetivo(objetivoSeleccionado);
    }




    /*public void borrarEvento(Evento evento){
        fbd.borrarEvento(evento);
    }

    public void nuevoEvento(Evento evento){
        fbd.insertarEvento(evento);
    }


    //Código VPrincipal
    public java.util.List<Evento> consultarEventos(String ubicacion, String fecha) {
        return fbd.consultarEventos(ubicacion, fecha);
    }*/

}
