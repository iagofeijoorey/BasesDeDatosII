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
    private ArrayList<Trato> tratos = new ArrayList<>();

    public Contacto(String pseudonimo, String nombre, String descripcion, Integer telefono) {
        this.pseudonimo = pseudonimo;
        this.telefono = telefono;
        this.descripcion = descripcion;
    }

    public Contacto(String pseudonimo, String nombre, String descripcion, Integer telefono, ArrayList<Trato> tratos) {
        this.pseudonimo = pseudonimo;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.tratos = tratos;
    }

    //Getters
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


    public ArrayList<Trato> getTratos() {
        return tratos;
    }

    //Setters
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


    public void setTratos(ArrayList<Trato> tratos) {
        this.tratos = tratos;
    }

    //OTRAS FUNCIONES
}