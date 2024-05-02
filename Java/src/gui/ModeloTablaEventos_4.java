/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import aplicacion.Evento;
import javax.swing.table.*;

/**
 *
 * @author basesdatos
 */
public class ModeloTablaEventos_4 extends AbstractTableModel{
    private java.util.List<Evento> eventos;

    public ModeloTablaEventos_4(){
        this.eventos=new java.util.ArrayList<Evento>();
    }

    public int getColumnCount (){
        return 4;
    }

    public int getRowCount(){
        return eventos.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Ubicación"; break;
            case 1: nombre= "Fecha"; break;
            case 2: nombre="Descripción"; break;
            case 3: nombre="Jefe a cargo"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.sql.Date.class; break;
            case 2: clase=java.lang.String.class; break;
            case 3: clase=java.lang.String.class; break;
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col){
        return col>0 && col<3;
    }

    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado= eventos.get(row).getUbicacion(); break;
            case 1: resultado= eventos.get(row).getFecha(); break;
            case 2: resultado= eventos.get(row).getDescripcion();break;
            case 3: resultado= eventos.get(row).getOrganizador();break;
        }
        return resultado;
    }

    @Override
    public void setValueAt(Object v, int row, int col){
        switch (col){
            case 0: eventos.get(row).setUbicacion((String) v); break;
            case 1: eventos.get(row).setFecha((String) v); break;
            case 2: eventos.get(row).setDescripcion((String) v);break;
            //case 3: eventos.get(row).setOrganizador((Acolito) v);break; todo arreglar esto
        }
    }

    public void setFilas(java.util.List<Evento> ejemplares){
        this.eventos=ejemplares;
        fireTableDataChanged();
    }

    public void nuevoEjemplar(Evento e){
        this.eventos.add(e);
        fireTableRowsInserted(this.eventos.size()-1, this.eventos.size()-1);
    }

    public void borrarEjemplar(int indice){
        this.eventos.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public java.util.List<Evento> getFilas(){
        return this.eventos;
    }

    public Evento obtenerEjemplar(int i){
        return this.eventos.get(i);
    }
}
