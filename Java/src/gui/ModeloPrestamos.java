/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import aplicacion.Acolito;

import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloPrestamos extends AbstractTableModel{
    private java.util.List<Acolito> acolitos;

    public ModeloPrestamos(){
        this.acolitos =new java.util.ArrayList<Acolito>();
    }

    public int getColumnCount (){
        return 4;
    }

    public int getRowCount(){
        return acolitos.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "ID Usuario"; break;
            case 1: nombre= "Nombre"; break;
            case 2: nombre="Email"; break;
            case 3: nombre="Préstamos vencidos"; break;
        }
        return nombre;
    }

    public Acolito getUsuario(Integer i){
        return acolitos.get(i);
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.String.class; break;
            case 2: clase=java.lang.String.class; break;
            case 3: clase=java.lang.Integer.class; break;
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
            case 0: resultado= acolitos.get(row).getAlias(); break;
            case 1: resultado= acolitos.get(row).getNombreCompleto(); break;
            case 2: resultado= acolitos.get(row).getEmail();break;
            case 3: resultado= acolitos.get(row).getPrestamosVencidos(); break;

        }
        return resultado;
    }

    public void setFilas(java.util.List<Acolito> acolitos){
        this.acolitos = acolitos;
        fireTableDataChanged();
    }

    public Acolito obtenerUsuario(int i){
        return this.acolitos.get(i);
    }

}
