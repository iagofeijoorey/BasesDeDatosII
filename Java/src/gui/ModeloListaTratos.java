/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import aplicacion.Trato;
/**
 *
 * @author basesdatos
 */
public class ModeloListaTratos extends javax.swing.AbstractListModel {
    java.util.List<Trato> elementos;

    public ModeloListaTratos(){
        this.elementos=new java.util.ArrayList<Trato>();
    }

    public int getSize(){
        return this.elementos.size();
    }

    public Trato getElementAt(int i){
        return elementos.get(i);
    }

    public void nuevoElemento(Trato t){
        this.elementos.add(t);
        fireIntervalAdded(this, this.elementos.size()-1, this.elementos.size()-1);
    }

    public void borrarElemento(int i){
        Trato t;
        t=this.elementos.get(i);
        this.elementos.remove(i);
        fireIntervalRemoved(this,i,i);
    }

    public void setElementos(java.util.List<Trato> elementos){
        this.elementos=elementos;
        fireContentsChanged(this, 0, elementos.size()-1);
    }

    public java.util.List<Trato> getElementos(){
        return this.elementos;
    }
}
