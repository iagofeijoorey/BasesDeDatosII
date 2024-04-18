/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import javax.swing.table.*;
import aplicacion.Categoria;
import javax.swing.AbstractListModel.*;
/**
 *
 * @author basesdatos
 */


public class ModeloListaCategorias extends javax.swing.AbstractListModel{
    private java.util.List<Categoria> categorias;


    public ModeloListaCategorias(){
        this.categorias=new java.util.ArrayList<Categoria>();
    }

    public Categoria getElementAt(int p){
        return categorias.get(p);
    }
    
    public void setContent(java.util.List<Categoria> categorias){
        this.categorias = categorias;
        
    }
    
    public int getColumnCount (){
        return 1;
    }
    
    public int getSize(){
        return categorias.size();
    }

    public int getRowCount(){
        return categorias.size();
    }
    
    public void setLista(java.util.ArrayList<Categoria> categorias){
        this.categorias = categorias;
    }
    
    public void addCategoria(Categoria categoria){
        categorias.add(categoria);
        //
    }

    public Object getValueAt(int row, int col){
        return categorias.get(row).getNombre();
    }

 
    public Categoria obtenerCategoria(int i){
        return this.categorias.get(i);
    }

}
