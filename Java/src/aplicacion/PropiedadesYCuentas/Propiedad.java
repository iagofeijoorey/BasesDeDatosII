package aplicacion.PropiedadesYCuentas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

   import java.sql.Date;
   import java.time.LocalDate;
import aplicacion.Acolito;
import aplicacion.Evento;

   import java.time.temporal.ChronoUnit;
   import java.util.ArrayList;

/**
 *
 * @author basesdatos
 */
public abstract class Propiedad {
    private int idPropiedad;
    private int valorActual;
    private Acolito gestor;
    private java.util.List<Evento> eventos;

    public Propiedad(int idPropiedad, int valorActual, Acolito gestor, java.util.List<Evento> eventos){
        this.idPropiedad = idPropiedad;
        this.valorActual = valorActual;
        this.gestor = gestor;
        this.eventos = eventos;
    }

    public Integer getIdPropiedad() {
        return idPropiedad;
    }

    public java.util.List<Evento> getEventos() {
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


    public Evento getEventoProximo() {
        LocalDate fechaActual = LocalDate.now();
        Evento eventoProximo = null;
        long diasRestantes = Long.MAX_VALUE; // Inicializamos con un valor muy grande

        for (Evento evento : eventos) {
            java.sql.Date sqlDate = Date.valueOf(evento.getFecha()); // Convierte la fecha del evento a un objeto java.sql.Date
            LocalDate localDate = sqlDate.toLocalDate(); // Convierte java.sql.Date a LocalDate

            // Calcula los días restantes hasta el evento
            long dias = ChronoUnit.DAYS.between(fechaActual, localDate);

            // Si el evento ocurre en el futuro y es más cercano que el anteriormente encontrado, actualiza la información del evento próximo
            if (dias >= 0 && dias < diasRestantes) {
                diasRestantes = dias;
                eventoProximo = evento;
            }
        }

        return eventoProximo;
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
