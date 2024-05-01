/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import aplicacion.Contacto;

/**
 *
 * @author basesdatos
 */
public class ModeloListaContactos extends javax.swing.AbstractListModel {
    java.util.List<Contacto> elementos;

    public ModeloListaContactos(){
        this.elementos=new java.util.ArrayList<Contacto>();
    }

    public int getSize(){
        return this.elementos.size();
    }

    public Contacto getElementAt(int i){
        return elementos.get(i);
    }

    public void nuevoElemento(Contacto c){
        this.elementos.add(c);
        fireIntervalAdded(this, this.elementos.size()-1, this.elementos.size()-1);
    }

    public void borrarElemento(int i){
        Contacto c;
        c = this.elementos.get(i);
        this.elementos.remove(i);
        fireIntervalRemoved(this,i,i);
    }

    public void setElementos(java.util.List<Contacto> elementos){
        this.elementos=elementos;
        fireContentsChanged(this, 0, elementos.size()-1);
    }

    public java.util.List<Contacto> getElementos(){
        return this.elementos;
    }
}
