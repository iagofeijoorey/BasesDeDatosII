/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import aplicacion.Acolito;
import aplicacion.TipoAcolito;

import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloUsuarios extends AbstractTableModel{
    private java.util.List<Acolito> acolitos;

    public ModeloUsuarios(){
        this.acolitos =new java.util.ArrayList<Acolito>();
    }

    public int getColumnCount (){
        return 6;
    }

    public int getRowCount(){
        return acolitos.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "IdUsuario"; break;
            case 1: nombre= "Clave"; break;
            case 2: nombre="Nombre"; break;
            case 3: nombre="Dirección"; break;
            case 4: nombre="Email"; break;
            case 5: nombre="tipoUsuario";break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.String.class; break;
            case 2: clase=java.lang.String.class; break;
            case 3: clase=java.lang.String.class; break;
            case 4: clase=java.lang.String.class; break;
            case 5: clase= TipoAcolito.class; break;
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
            case 1: resultado= acolitos.get(row).getContraseña(); break;
            case 2: resultado= acolitos.get(row).getNombreCompleto();break;
            case 4: resultado= acolitos.get(row).getEmail(); break;
            case 3: resultado= acolitos.get(row).getDireccion(); break;
            case 5: resultado= acolitos.get(row).getTipoAcolito(); break;
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
