/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Evento;
import aplicacion.Contacto;
import java.sql.*;
import java.util.List;

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
}/*
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
            stmUsuario.setString(5, null); //todo revisar si se puede hacer esto (meter un null)
            stmUsuario.setString(6, evento.getOrganizador().getAlias());
            stmUsuario.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

    public List<Evento> consultarEventos(){
    List<Evento> resultado = null;
        Evento eventoActual;
        Connection con;
        PreparedStatement stmEventos = null;
        ResultSet rsEventos;

        con = this.getConexion();
        resultado = new java.util.ArrayList<Evento>();
        try {
            stmEventos = con.prepareStatement("select ubicacion, fecha, tipoevento, descripcion, autorizador, organizador " +
                    "from eventos ");
            rsEventos = stmEventos.executeQuery();
            while (rsEventos.next()) {
                eventoActual = new Evento(rsEventos.getString("ubicacion"), rsEventos.getString("fecha"),
                        rsEventos.getString("tipoevento"), rsEventos.getString("descripcion"), null);
                stmEventos = con.prepareStatement("select * " +
                        "from acólitos " +
                        "where alias = ?");
                stmEventos.setString(1, rsEventos.getString("organizador"));
                rsEventos = stmEventos.executeQuery();
                if (rsEventos.next()) {
                    eventoActual.setOrganizador(new Acolito(rsEventos.getString("alias"), rsEventos.getString("contraseña"),
                            rsEventos.getString("nombrecompleto"), rsEventos.getString("direccion"), 0,
                            aplicacion.TipoAcolito.valueOf(rsEventos.getString("tipo_usuario"))));
                }

                stmEventos = con.prepareStatement("select * " +
                        "from acólitos " +
                        "where alias = ?");

                stmEventos.setString(1, rsEventos.getString("autorizador"));
                rsEventos = stmEventos.executeQuery();
                if (rsEventos.next()) {
                    eventoActual.setAutorizador(new Acolito(rsEventos.getString("alias"), rsEventos.getString("contraseña"),
                            rsEventos.getString("nombrecompleto"), rsEventos.getString("direccion"), 0,
                            aplicacion.TipoAcolito.valueOf(rsEventos.getString("tipo_usuario"))));
                }
                resultado.add(eventoActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmEventos != null) {
                    stmEventos.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }

    public List<Evento> consultarEventos(Acolito acolito){
        List<Evento> resultado = null;
        Evento eventoActual;
        Connection con;
        PreparedStatement stmEventos = null;
        ResultSet rsEventos;

        con = this.getConexion();
        resultado = new java.util.ArrayList<Evento>();
        try {
            stmEventos = con.prepareStatement("select ubicacion, fecha, tipoevento, descripcion, autorizador, organizador " +
                    "from eventos " +
                    "where organizador = ? or autorizador = ?");
            stmEventos.setString(1, acolito.getAlias());
            stmEventos.setString(2, acolito.getAlias());
            rsEventos = stmEventos.executeQuery();
            while (rsEventos.next()) {
                eventoActual = new Evento(rsEventos.getString("ubicacion"), rsEventos.getString("fecha"),
                        rsEventos.getString("tipoevento"), rsEventos.getString("descripcion"), null);
                stmEventos = con.prepareStatement("select * " +
                        "from acólitos " +
                        "where alias = ?");
                stmEventos.setString(1, rsEventos.getString("organizador"));
                rsEventos = stmEventos.executeQuery();
                if (rsEventos.next()) {
                    eventoActual.setOrganizador(new Acolito(rsEventos.getString("alias"), rsEventos.getString("contraseña"),
                            rsEventos.getString("nombrecompleto"), rsEventos.getString("direccion"), 0,
                            aplicacion.TipoAcolito.valueOf(rsEventos.getString("tipo_usuario"))));
                }

                stmEventos = con.prepareStatement("select * " +
                        "from acólitos " +
                        "where alias = ?");

                stmEventos.setString(1, rsEventos.getString("autorizador"));
                rsEventos = stmEventos.executeQuery();
                if (rsEventos.next()) {
                    eventoActual.setAutorizador(new Acolito(rsEventos.getString("alias"), rsEventos.getString("contraseña"),
                            rsEventos.getString("nombrecompleto"), rsEventos.getString("direccion"), 0,
                            aplicacion.TipoAcolito.valueOf(rsEventos.getString("tipo_usuario"))));
                }
                resultado.add(eventoActual);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if (stmEventos != null) {
                    stmEventos.close();
                }
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
        return resultado;
    }


}
*/