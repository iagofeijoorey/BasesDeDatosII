/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import aplicacion.Acolito;

/**
 *
 * @author basesdatos
 */


public class ModeloListaCategorias extends javax.swing.AbstractListModel{
    private java.util.List<Acolito> acolitos;


    public ModeloListaCategorias(){
        this.acolitos =new java.util.ArrayList<Acolito>();
    }

    public Acolito getElementAt(int p){
        return acolitos.get(p);
    }
    
    public void setContent(java.util.List<Acolito> acolitos){
        this.acolitos = acolitos;
        
    }
    
    public int getColumnCount (){
        return 1;
    }
    
    public int getSize(){
        return acolitos.size();
    }

    public int getRowCount(){
        return acolitos.size();
    }
    
    public void setLista(java.util.ArrayList<Acolito> acolitos){
        this.acolitos = acolitos;
    }
    
    public void addCategoria(Acolito acolito){
        acolitos.add(acolito);
        //
    }

    public Object getValueAt(int row, int col){
        return acolitos.get(row).getNombre();
    }

 
    public Acolito obtenerCategoria(int i){
        return this.acolitos.get(i);
    }

}
