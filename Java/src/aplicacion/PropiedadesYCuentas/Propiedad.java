package aplicacion.PropiedadesYCuentas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

   import java.sql.Date;
   import java.time.LocalDate;
import aplicacion.Acolito;
import aplicacion.Evento;

import java.util.ArrayList;

/**
 *
 * @author basesdatos
 */
public abstract class Propiedad {
    private int idPropiedad;
    private int valorActual;
    private Acolito gestor;
    private ArrayList<Evento> eventos= new ArrayList<>();

    public Propiedad(int idPropiedad, int valorActual, Acolito gestor){
        this.idPropiedad = idPropiedad;
        this.valorActual = valorActual;
        this.gestor = gestor;
    }

    public Integer getIdPropiedad() {
        return idPropiedad;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public Integer getValorActual() {
        return valorActual;
    }

    public Acolito getGestor() {
        return gestor;
    }

    public void setIdPropiedad(int idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public void setValorActual(int valorActual) {
        this.valorActual = valorActual;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }



    public Evento getEventoActual() {
        LocalDate fechaActual = LocalDate.now();
        for (Evento evento : eventos) {
            java.sql.Date sqlDate = Date.valueOf(evento.getFecha());// tu fecha SQL
            LocalDate localDate = sqlDate.toLocalDate();
            if (localDate.equals(fechaActual)) {
                return evento;
            }
        }
        return null;
    }

    public void addEvento(Evento e){
        eventos.add(e);
    }

    public void setGestor(Acolito gestor) {
        this.gestor = gestor;
    }
    public abstract String getTipoGeneral();
    public abstract String getTipoString();
}
