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
import aplicacion.TipoAcolito;

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
            java.sql.Date fechaIngresoSQL = new java.sql.Date(evento.getFecha().getTime()); // Convertimos el tipo java.util.Date a java.sql.Date
            stmUsuario.setDate(3, fechaIngresoSQL);
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

    public List<Evento> consultarEventos() {

        List<Evento> resultado = null;
        Evento eventoActual;
        Connection con;
        PreparedStatement stmEventos = null;
        ResultSet rsEventos;

        con = this.getConexion();
        resultado = new java.util.ArrayList<Evento>();

        try {

            stmEventos = con.prepareStatement("select * from eventos");
            rsEventos = stmEventos.executeQuery();

            while (rsEventos.next()) {

                eventoActual = new Evento(rsEventos.getString("ubicacion"), rsEventos.getDate("fecha"),
                        rsEventos.getString("tipoevento"), rsEventos.getString("descripcion"), null);

                stmEventos = con.prepareStatement("select a.*, " +
                        "       case " +
                        "           when c.alias is not null then 'Cabecilla' " +
                        "           when g.alias is not null then 'Gestor' " +
                        "           when gd.alias is not null then 'GuiaEspiritual' " +
                        "           when jd.alias is not null then 'JefeDivision' " +
                        "           when mb.alias is not null then 'Normal' " +
                        "           end as tipo, " +
                        "       mb.jefe as jefeDivision, " +
                        "       jd.nombreDivision as nombreDivision " +
                        "from acólitos a " +
                        "         left join cabecillas c on a.alias = c.alias " +
                        "         left join gestor_interno g on a.alias = g.alias " +
                        "         left join guia_espiritual gd on a.alias = gd.alias " +
                        "         left join jefes_de_division jd on a.alias = jd.alias " +
                        "         left join miembros_basicos mb on a.alias = mb.alias " +
                        "where a.alias like ?");

                String aliasOrg = rsEventos.getString("organizador");
                stmEventos.setString(1, aliasOrg);
                rsEventos = stmEventos.executeQuery();
                if (rsEventos.next()) {
                    eventoActual.setOrganizador(new Acolito(aliasOrg, rsEventos.getString("contraseña"), rsEventos.getDate("fechaingreso"), rsEventos.getString("nombreCompleto"),
                            rsEventos.getDouble("dinero"), rsEventos.getInt("telefono"), rsEventos.getString("direccion"),
                            rsEventos.getInt("influencia"), TipoAcolito.stringToTipoAcolito("tipo"), rsEventos.getBoolean("primeraEntrada"),
                            rsEventos.getString("jefeDivision"), rsEventos.getString("nombreDivision")));
                }

                stmEventos = con.prepareStatement("select a.*, " +
                        "       case " +
                        "           when c.alias is not null then 'Cabecilla' " +
                        "           when g.alias is not null then 'Gestor' " +
                        "           when gd.alias is not null then 'GuiaEspiritual' " +
                        "           when jd.alias is not null then 'JefeDivision' " +
                        "           when mb.alias is not null then 'Normal' " +
                        "           end as tipo, " +
                        "       mb.jefe as jefeDivision, " +
                        "       jd.nombreDivision as nombreDivision " +
                        "from acólitos a " +
                        "         left join cabecillas c on a.alias = c.alias " +
                        "         left join gestor_interno g on a.alias = g.alias " +
                        "         left join guia_espiritual gd on a.alias = gd.alias " +
                        "         left join jefes_de_division jd on a.alias = jd.alias " +
                        "         left join miembros_basicos mb on a.alias = mb.alias " +
                        "where a.alias like ?");

                String aliasAut = rsEventos.getString("autorizador");
                stmEventos.setString(1, aliasAut);
                rsEventos = stmEventos.executeQuery();
                if (rsEventos.next()) {
                    eventoActual.setAutorizador(new Acolito(aliasOrg, rsEventos.getString("contraseña"), rsEventos.getDate("fechaingreso"), rsEventos.getString("nombreCompleto"),
                            rsEventos.getDouble("dinero"), rsEventos.getInt("telefono"), rsEventos.getString("direccion"),
                            rsEventos.getInt("influencia"), TipoAcolito.stringToTipoAcolito("tipo"), rsEventos.getBoolean("primeraEntrada"),
                            rsEventos.getString("jefeDivision"), rsEventos.getString("nombreDivision")));
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

    public List<Evento> consultarEventos(String alias){

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
            stmEventos.setString(1, alias);
            stmEventos.setString(2, alias);
            rsEventos = stmEventos.executeQuery();

            while (rsEventos.next()) {

                eventoActual = new Evento(rsEventos.getString("ubicacion"), rsEventos.getDate("fecha"),
                        rsEventos.getString("tipoevento"), rsEventos.getString("descripcion"), null);

                stmEventos = con.prepareStatement("select a.*, " +
                        "       case " +
                        "           when c.alias is not null then 'Cabecilla' " +
                        "           when g.alias is not null then 'Gestor' " +
                        "           when gd.alias is not null then 'GuiaEspiritual' " +
                        "           when jd.alias is not null then 'JefeDivision' " +
                        "           when mb.alias is not null then 'Normal' " +
                        "           end as tipo, " +
                        "       mb.jefe as jefeDivision, " +
                        "       jd.nombreDivision as nombreDivision " +
                        "from acólitos a " +
                        "         left join cabecillas c on a.alias = c.alias " +
                        "         left join gestor_interno g on a.alias = g.alias " +
                        "         left join guia_espiritual gd on a.alias = gd.alias " +
                        "         left join jefes_de_division jd on a.alias = jd.alias " +
                        "         left join miembros_basicos mb on a.alias = mb.alias " +
                        "where a.alias like ?");

                String aliasOrg = rsEventos.getString("organizador");
                stmEventos.setString(1, aliasOrg);
                rsEventos = stmEventos.executeQuery();
                if (rsEventos.next()) {
                    eventoActual.setOrganizador(new Acolito(aliasOrg, rsEventos.getString("contraseña"), rsEventos.getDate("fechaingreso"), rsEventos.getString("nombreCompleto"),
                            rsEventos.getDouble("dinero"), rsEventos.getInt("telefono"), rsEventos.getString("direccion"),
                            rsEventos.getInt("influencia"), TipoAcolito.stringToTipoAcolito("tipo"), rsEventos.getBoolean("primeraEntrada"),
                            rsEventos.getString("jefeDivision"), rsEventos.getString("nombreDivision")));
                }

                stmEventos = con.prepareStatement("select a.*, " +
                        "       case " +
                        "           when c.alias is not null then 'Cabecilla' " +
                        "           when g.alias is not null then 'Gestor' " +
                        "           when gd.alias is not null then 'GuiaEspiritual' " +
                        "           when jd.alias is not null then 'JefeDivision' " +
                        "           when mb.alias is not null then 'Normal' " +
                        "           end as tipo, " +
                        "       mb.jefe as jefeDivision, " +
                        "       jd.nombreDivision as nombreDivision " +
                        "from acólitos a " +
                        "         left join cabecillas c on a.alias = c.alias " +
                        "         left join gestor_interno g on a.alias = g.alias " +
                        "         left join guia_espiritual gd on a.alias = gd.alias " +
                        "         left join jefes_de_division jd on a.alias = jd.alias " +
                        "         left join miembros_basicos mb on a.alias = mb.alias " +
                        "where a.alias like ?");

                String aliasAut = rsEventos.getString("autorizador");
                stmEventos.setString(1, aliasAut);
                rsEventos = stmEventos.executeQuery();
                if (rsEventos.next()) {
                    eventoActual.setAutorizador(new Acolito(aliasOrg, rsEventos.getString("contraseña"), rsEventos.getDate("fechaingreso"), rsEventos.getString("nombreCompleto"),
                            rsEventos.getDouble("dinero"), rsEventos.getInt("telefono"), rsEventos.getString("direccion"),
                            rsEventos.getInt("influencia"), TipoAcolito.stringToTipoAcolito("tipo"), rsEventos.getBoolean("primeraEntrada"),
                            rsEventos.getString("jefeDivision"), rsEventos.getString("nombreDivision")));
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
