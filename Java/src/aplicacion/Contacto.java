package aplicacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author basesdatos
 */
public class Contacto {
    private String pseudonimo;
    private String nombre;
    private Integer telefono;
    private String descripcion;
    private Acolito acolito;
    private ArrayList<Trato> tratos = new ArrayList<>();

    public Contacto(String pseudonimo, String nombre, String descripcion, Integer telefono, Acolito acolito) {
        this.pseudonimo = pseudonimo;
        this.acolito = acolito;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    public Contacto(String pseudonimo, String nombre, String descripcion, Integer telefono, Acolito acolito, ArrayList<Trato> tratos) {
        this.pseudonimo = pseudonimo;
        this.acolito = acolito;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.tratos = tratos;
    }

    public String getPseudonimo() {
        return pseudonimo;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Acolito getAcolito() {
        return acolito;
    }

    public ArrayList<Trato> getTratos() {
        return tratos;
    }

    public void setPseudonimo(String pseudonimo) {
        this.pseudonimo = pseudonimo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setAcolito(Acolito acolito) {
        this.acolito = acolito;
    }

    public void setTratos(ArrayList<Trato> tratos) {
        this.tratos = tratos;
    }
}