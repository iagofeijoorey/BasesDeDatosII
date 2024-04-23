/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Acolito;
import aplicacion.Contacto;
import aplicacion.TipoAcolito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author basesdatos
 */
public class DAOContactos extends AbstractDAO {

   public DAOContactos(Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }


    public void insertarContacto(Contacto contacto, Acolito acolito){
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsIdUsuario;
        String idUsuario=null;

        con=super.getConexion();
        try {
            stmUsuario=con.prepareStatement("insert into contactos(pseudonimo, nombre, telefono, descripcion) "+
                                          "values (?,?,?,?)");
            stmUsuario.setString(1, contacto.getPseudonimo());
            stmUsuario.setString(2, contacto.getNombre());
            stmUsuario.setInt(3, contacto.getTelefono());
            stmUsuario.setString(4, contacto.getDescripcion());
            stmUsuario.executeUpdate();
            if (contacto.getTratos().isEmpty()) {
                stmUsuario = con.prepareStatement("insert into sersolocontacto(contacto, acólito) values (?,?)");
                stmUsuario.setString(1, contacto.getPseudonimo());
                stmUsuario.setString(1, contacto.getPseudonimo());
            }
            else{
                //todo implementación de tratos entera
                System.out.println("Easter egg");
            }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

    /**
     * Consultar contacto genérico (creo que no se usa, no la voy a implementar aún)
     */
    public void consultarContacto(){
   }

    /**
     * Consultar contacto dado el acólito del que es contacto
     */
    public void consultarContactosDeAcolito(Acolito acolito, String pseudonimo, String nombre){
    }

    /**
     * Consultar contacto dado el nombre o alias aproximado (usamos %) del acólito del que es contacto
     */
    public void consultarContactosDeAcolito(String aliasAcolito, String nombreAcolito, String pseudonimoContacto, String nombreContacto){
    }
}