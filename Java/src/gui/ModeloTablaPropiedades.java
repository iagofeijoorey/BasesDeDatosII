/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import javax.swing.table.*;
import aplicacion.PropiedadesYCuentas.Propiedad;
/**
 *
 * @author basesdatos
*/
public class ModeloTablaPropiedades extends AbstractTableModel{
    private java.util.List<Propiedad> propiedades;

    public ModeloTablaPropiedades(){
        this.propiedades =new java.util.ArrayList<Propiedad>();
    }

    public int getColumnCount (){
        return 3;
    }

    public int getRowCount(){
        return propiedades.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "IdPropiedad"; break;
            case 1: nombre= "Tipo"; break;
            case 2: nombre="Subtipo"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.Integer.class; break;
            case 1: clase= java.lang.String.class; break;
            case 2: clase=java.lang.String.class; break;
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
            case 0: resultado= propiedades.get(row).getIdPropiedad(); break;
            case 1: resultado= propiedades.get(row).getTipoGeneral(); break;
            case 2: resultado= propiedades.get(row).getTipoString();break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<Propiedad> propiedades){
        this.propiedades = propiedades;
        fireTableDataChanged();
    }

    public Propiedad obtenerPropiedad(int i){
        return this.propiedades.get(i);
    }

}
