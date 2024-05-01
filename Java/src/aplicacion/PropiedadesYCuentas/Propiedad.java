package aplicacion.PropiedadesYCuentas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import aplicacion.Acolito;

/**
 *
 * @author basesdatos
 */
public abstract class Propiedad {
    private int idPropiedad;
    private int valorActual;
    private Acolito gestor;

    public Propiedad(int idPropiedad, int valorActual, Acolito gestor){
        this.idPropiedad = idPropiedad;
        this.valorActual = valorActual;
        this.gestor = gestor;
    }

    public int getIdPropiedad() {
        return idPropiedad;
    }

    public int getValorActual() {
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

    public void setGestor(Acolito gestor) {
        this.gestor = gestor;
    }
}
