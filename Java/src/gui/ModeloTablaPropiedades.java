/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package gui;
import aplicacion.Usuario;
import javax.swing.table.*;
/**
 *
 * @author basesdatos

public class ModeloUsuarios extends AbstractTableModel{
    private java.util.List<Usuario> usuarios;

    public ModeloTablaPropiedades(){
        this.propiedades =new java.util.ArrayList<Propiedad>();
    }

    public int getColumnCount (){
        return 6;
    }

    public int getRowCount(){
        return usuarios.size();
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
            case 5: clase=aplicacion.TipoUsuario.class; break;
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
            case 0: resultado= usuarios.get(row).getIdUsuario(); break;
            case 1: resultado= usuarios.get(row).getClave(); break;
            case 2: resultado=usuarios.get(row).getNombre();break;
            case 4: resultado=usuarios.get(row).getEmail(); break;
            case 3: resultado=usuarios.get(row).getDireccion(); break;
            case 5: resultado=usuarios.get(row).getTipoUsuario(); break;
        }
        return resultado;
    }

    public void setFilas(java.util.List<Usuario> usuarios){
        this.usuarios=usuarios;
        fireTableDataChanged();
    }

    public Usuario obtenerUsuario(int i){
        return this.usuarios.get(i);
    }

}
*/
