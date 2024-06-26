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

    public int actualizarObjetivo(Objetivo objetivoSeleccionado) {
        if (objetivoSeleccionado.getIdObjetivo() == -1) {
            return fbd.insertarObjetivo(objetivoSeleccionado);
        }
        else
         fbd.actualizarObjetivo(objetivoSeleccionado);
        return objetivoSeleccionado.getIdObjetivo();
    }

    public void actualizarRecompensaDinero(RecompensaDinero recompensa) {
        if (recompensa.getIdRecompensa() == -1) {;
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




    public void borrarEvento(Evento evento){
        fbd.borrarEvento(evento);
    }

    public void anhadirEvento(Evento evento){
        fbd.anhadirEvento(evento);
    }


    public void nuevoEvento(Evento evento){
        //fbd.insertarEvento(evento);
    }


    //Código VPrincipal
    public java.util.List<Evento> consultarEventos(Evento evento) {
        return fbd.consultarEventos(evento);
    }
    public java.util.List<Evento> consultarEventosSinArgs(){
        return fbd.consultarEventosSinArgs();
    }

}
