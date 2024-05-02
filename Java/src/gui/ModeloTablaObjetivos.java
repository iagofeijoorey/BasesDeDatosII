/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import aplicacion.Objetivo;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author basesdatos
 */
public class ModeloTablaObjetivos extends AbstractTableModel{
    private java.util.List<Objetivo> objetivos;

    public ModeloTablaObjetivos(){
        this.objetivos = new java.util.ArrayList<Objetivo>();
    }

    public int getColumnCount (){
        return 3;
    }

    public int getRowCount(){
        return objetivos.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Objetivo"; break;
            case 1: nombre= "Recompensa"; break;
            case 2: nombre="Prioridad"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= String.class; break;
            case 1: clase= String.class; break;
            case 2: clase= Integer.class; break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col){
        return false;
    }

    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado= objetivos.get(row).getDescripcion(); break;
            case 1: resultado= objetivos.get(row).getRecompensa(); break;
            case 2: resultado= objetivos.get(row).getPrioridad();break;
        }
        return resultado;
    }

    @Override
    public void setValueAt(Object v, int row, int col){
        switch (col){
            case 0: objetivos.get(row).setUbicacion((String) v); break;
            case 1: objetivos.get(row).setFecha((String) v); break;
            case 2: objetivos.get(row).setDescripcion((String) v);break;
            //case 3: eventos.get(row).setOrganizador((Acolito) v);break; todo arreglar esto
        }
    }

    public void setFilas(java.util.List<Objetivo> objetivos){
        this.objetivos=objetivos;
        fireTableDataChanged();
    }

    public void nuevoEjemplar(Objetivo e){
        this.objetivos.add(e);
        fireTableRowsInserted(this.objetivos.size()-1, this.objetivos.size()-1);
    }

    public void borrarEjemplar(int indice){
        this.objetivos.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public java.util.List<Objetivo> getFilas(){
        return this.objetivos;
    }

    public Objetivo obtenerEjemplar(int i){
        return this.objetivos.get(i);
    }
}
