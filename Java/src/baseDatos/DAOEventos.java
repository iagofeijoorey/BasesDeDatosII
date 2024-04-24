/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Evento;
import aplicacion.Contacto;
import java.sql.*;
import aplicacion.Acolito;
/**
 *
 * @author basesdatos
 */
public class DAOEventos extends AbstractDAO {

    public DAOEventos(Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public void insertarEvento(Evento evento){
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsIdUsuario;
        String idUsuario=null;

        con=super.getConexion();
        try {
            stmUsuario=con.prepareStatement("insert into public.eventos(ubicacion, fecha, tipoevento, descripcion, autorizador, organizador) "+
                    "values (?,?,?,?,?,?)");
            stmUsuario.setString(1, evento.getUbicacion());
            stmUsuario.setString(2, evento.getFecha());
            stmUsuario.setString(3, evento.getTipoEvento());
            stmUsuario.setString(4, evento.getDescripcion());
            stmUsuario.setString(5, evento.getAutorizador());
            stmUsuario.setString(6, evento.getOrganizador());
            stmUsuario.executeUpdate();


        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
}
